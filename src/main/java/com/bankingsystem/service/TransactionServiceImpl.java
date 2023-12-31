package com.bankingsystem.service;

import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.Transaction;
import com.bankingsystem.enums.TransactionType;
import com.bankingsystem.repository.AccountRepository;
import com.bankingsystem.repository.TransactionRepository;
import com.bankingsystem.utils.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;


    @Override
    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new NotFoundException("Transaction not found with ID: " + transactionId));
    }

    @Override
    public List<Transaction> listTransactionsByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    @Override
    public void transferFunds(Long sourceAccountId, Long targetAccountId, BigDecimal amount) {
        Account sourceAccount = getAccountById(sourceAccountId);
        Account targetAccount = getAccountById(targetAccountId);

        // Perform additional checks and validations for the transfer, such as verifying sufficient balance, handling currency conversions, etc.

        // Update the source account balance
        BigDecimal newSourceBalance = sourceAccount.getBalance().subtract(amount);
        sourceAccount.setBalance(newSourceBalance);
        accountRepository.save(sourceAccount);

        // Update the target account balance
        BigDecimal newTargetBalance = targetAccount.getBalance().add(amount);
        targetAccount.setBalance(newTargetBalance);
        accountRepository.save(targetAccount);

        // Create transaction records for both accounts
        Transaction sourceTransaction = Transaction.builder()
                .amount(amount)
                .receiverAccountNumber(targetAccount.getAccountNumber())
                .transactionDate(LocalDateTime.now())
                .transactionType(TransactionType.DEBIT)
                .currency("USD")
                .isSuccessful(true)
                .build();

        sourceTransaction.setAccount(sourceAccount);
        transactionRepository.save(sourceTransaction);

        Transaction targetTransaction = Transaction.builder()
                .amount(amount)
                .receiverAccountNumber(sourceAccount.getAccountNumber())
                .transactionDate(LocalDateTime.now())
                .transactionType(TransactionType.CREDIT)
                .currency("USD")
                .isSuccessful(true)
                .build();

        targetTransaction.setAccount(targetAccount);
        transactionRepository.save(targetTransaction);
    }

    private Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Account not found with ID: " + accountId));
    }
}