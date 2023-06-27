package com.bankingsystem.model.transaction;

import com.bankingsystem.entity.Account;
import com.bankingsystem.enums.TransactionType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionDTO {


    private Long id;
    private String transactionNumber;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", message = "Amount must be greater than or equal to zero")
    private BigDecimal amount;

    private String description;

    private boolean isSuccessful;

    @NotBlank(message = "Currency is required")
    private String currency;

    @DecimalMin(value = "0.0", message = "Exchange rate must be greater than or equal to zero")
    private BigDecimal exchangeRate;

    @NotNull(message = "Transaction type is required")
    private TransactionType transactionType;

    @NotNull(message = "Account is required")
    @Valid
    private Account account;
}
