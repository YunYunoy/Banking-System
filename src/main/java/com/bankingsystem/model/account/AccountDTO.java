package com.bankingsystem.model.account;

import com.bankingsystem.entity.DebitCard;
import com.bankingsystem.entity.Transaction;
import com.bankingsystem.entity.User;
import com.bankingsystem.enums.AccountStatus;
import com.bankingsystem.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class AccountDTO {


    private Long id;
    private String accountNumber;

    @NotNull(message = "Balance is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be greater than zero")
    private BigDecimal balance;

    @Past(message = "Last interest calculation date must be in the past")
    private Date lastInterestCalculation;

    @DecimalMin(value = "0.0", message = "Interest rate must be greater than or equal to zero")
    private double interestRate;

    @NotNull(message = "Account status is required")
    private AccountStatus accountStatus;

    @NotNull(message = "Account type is required")
    private AccountType accountType;

    @Valid
    private User user;

    @Valid
    private List<Transaction> transactions;

    @Valid
    private List<DebitCard> debitCard;
}
