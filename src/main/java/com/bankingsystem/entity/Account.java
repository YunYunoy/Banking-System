package com.bankingsystem.entity;


import com.bankingsystem.enums.AccountStatus;
import com.bankingsystem.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "accounts")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "TYPE", length = 4)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", unique = true, length = 26)
    private String accountNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_interest_calculation")
    private Date lastInterestCalculation;

    @Column(name = "interest_rate")
    private double interestRate;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private AccountStatus accountStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<DebitCard> debitCard;

}
