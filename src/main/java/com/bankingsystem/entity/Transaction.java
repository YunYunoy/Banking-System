package com.bankingsystem.entity;

import com.bankingsystem.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_number", unique = true)
    private String transactionNumber;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    @Column(name = "description")
    private String description;

    @Column(name = "is_successful")
    private boolean isSuccessful;

    @Column(name = "currency")
    private String currency;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;


    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
