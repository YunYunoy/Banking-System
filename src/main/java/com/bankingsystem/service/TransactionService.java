package com.bankingsystem.service;

import com.bankingsystem.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {


    Transaction getTransactionById(Long transactionId);

    List<Transaction> listTransactionsByAccountId(Long accountId);

    void transferFunds(Long sourceAccountId, Long targetAccountId, BigDecimal amount);

     void depositFunds(Long accountId, BigDecimal amount) ;

    void withdrawFunds(Long accountId, BigDecimal amount) ;
}
