package com.bankingsystem.model.account;

import com.bankingsystem.entity.DebitCard;
import com.bankingsystem.entity.Transaction;
import com.bankingsystem.entity.User;
import com.bankingsystem.enums.AccountStatus;
import com.bankingsystem.enums.AccountType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class RequestAccount {

    @Builder.Default
    private BigDecimal balance = BigDecimal.valueOf(0.0);

    @Past(message = "Last interest calculation date must be in the past")
    private Date lastInterestCalculation;

    @DecimalMin(value = "0.0", message = "Interest rate must be greater than or equal to zero")
    private double interestRate;

    @NotNull(message = "Account status is required")
    private AccountStatus accountStatus;

    @NotNull(message = "Account type is required")
    private AccountType accountType;

}
