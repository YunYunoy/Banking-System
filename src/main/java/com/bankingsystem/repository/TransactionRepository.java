package com.bankingsystem.repository;

import com.bankingsystem.entity.Account;
import com.bankingsystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
