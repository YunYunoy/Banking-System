package com.bankingsystem.service;

import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.DebitCard;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountById(Long accountId);

    List<Account> getAllAccounts();

    void deleteAccount(Long accountId);



    DebitCard createDebitCard(Long accountId, DebitCard debitCard);

    List<DebitCard> getAccountDebitCards(Long accountId);

}
