package com.bankingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "debit_cards")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DebitCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "cvv")
    private String cvv;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "is_active")
    private boolean isActive;

}
