package com.bankingsystem.bootstrap;

import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.DebitCard;
import com.bankingsystem.entity.Transaction;
import com.bankingsystem.entity.User;
import com.bankingsystem.enums.AccountStatus;
import com.bankingsystem.enums.TransactionType;
import com.bankingsystem.repository.AccountRepository;
import com.bankingsystem.repository.DebitCardRepository;
import com.bankingsystem.repository.TransactionRepository;
import com.bankingsystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
@AllArgsConstructor
@Slf4j
public class CreateData implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final DebitCardRepository debitCardRepository;

    @Override
    public void run(String... args) throws Exception {
        createData();
    }

    private void createData() {

        accountRepository.deleteAll();
        userRepository.deleteAll();
        transactionRepository.deleteAll();
        debitCardRepository.deleteAll();


//         Create an Account
        Account account = Account.builder()
                .accountNumber("123456789")
                .balance(BigDecimal.valueOf(1000))
                .lastInterestCalculation(new java.util.Date())
                .interestRate(0.05)
                .accountStatus(AccountStatus.ACTIVE)
                .transactions(new ArrayList<>())
                .debitCard(new ArrayList<>())
                .build();

        // Create a User
        User user = User.builder()
                .username("john_doe")
                .email("john.doe@example.com")
                .phoneNumber("1234567890")
                .street("123 Main St")
                .city("City")
                .postalCode("12345")
                .termsAccepted(true)
                .accounts(new ArrayList<>())
                .build();

        // Create a DebitCard
        DebitCard debitCard = DebitCard.builder()
                .cardNumber("1234567812345678")
                .expirationDate(LocalDate.of(2025, 12, 31))
                .cvv("123")
                .isActive(true)
                .build();

        // Create Transactions
        Transaction transaction1 = Transaction.builder()
                .amount(BigDecimal.valueOf(500))
                .transactionDate(LocalDateTime.now())
                .transactionNumber(UUID.randomUUID().toString())
                .description("Payment")
                .isSuccessful(true)
                .currency("USD")
                .exchangeRate(BigDecimal.ONE)
                .transactionType(TransactionType.DEBIT)
                .build();

        Transaction transaction2 = Transaction.builder()
                .amount(BigDecimal.valueOf(200))
                .transactionNumber(UUID.randomUUID().toString())
                .transactionDate(LocalDateTime.now())
                .description("Withdrawal")
                .isSuccessful(true)
                .currency("USD")
                .exchangeRate(BigDecimal.ONE)
                .transactionType(TransactionType.DEBIT)
                .build();

        // Associate entities
        account.setUser(user);
        account.getTransactions().add(transaction1);
        account.getTransactions().add(transaction2);
        account.getDebitCard().add(debitCard);

//        // Save entities
        accountRepository.save(account);
//        userRepository.save(user);
//        debitCardRepository.save(debitCard);
//        transactionRepository.saveAll(List.of(transaction1, transaction2));

        log.info("accounts count: " + accountRepository.count() + " users count: " + userRepository.count());
        log.info("cards count: " + debitCardRepository.count() + " transactions count: " + transactionRepository.count());
    }
}
