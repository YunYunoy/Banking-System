package com.bankingsystem.repository;

import com.bankingsystem.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long id);

    Page<Transaction> findByAccountIdOrderByTransactionDateDesc(Long id, Pageable pageable);
}
