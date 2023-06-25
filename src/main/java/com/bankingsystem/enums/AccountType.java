package com.bankingsystem.enums;

public enum AccountType {
    SAVINGS("Savings"),
    CHECKING("Checking");

    private final String type;

    AccountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
    }