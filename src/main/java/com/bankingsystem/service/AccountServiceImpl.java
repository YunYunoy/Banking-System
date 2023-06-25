package com.bankingsystem.service;


import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.DebitCard;
import com.bankingsystem.repository.AccountRepository;
import com.bankingsystem.repository.DebitCardRepository;
import com.bankingsystem.repository.TransactionRepository;
import com.bankingsystem.utils.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final DebitCardRepository debitCardRepository;


    // TODO: implement DTO
    // TODO: Check
    @Override
    public Account createAccount(Account account) {
        // Additional logic for creating an account, such as generating an account number, calculating interest, etc.
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Account not found with ID: " + id));
    }


    // TODO: implement DTO
    // TODO: Check
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    // TODO: implement DTO
    // TODO: Check
    @Override
    public void deleteAccount(Long id) {
        Account account = getAccountById(id);
        accountRepository.delete(account);
    }


    // TODO: implement DTO
    // TODO: Check
    @Override
    public DebitCard createDebitCard(Long id, DebitCard debitCard) {
        Account account = getAccountById(id);
        debitCard.setAccount(account);
        // Additional logic for creating a debit card, such as generating a card number, setting expiration date, etc.
        return debitCardRepository.save(debitCard);
    }

    // TODO: implement DTO
    // TODO: Check
    @Override
    public List<DebitCard> getAccountDebitCards(Long id) {
        Account account = getAccountById(id);
        return account.getDebitCard();
    }


}
