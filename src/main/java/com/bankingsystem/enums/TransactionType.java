package com.bankingsystem.enums;

public enum TransactionType {

    DEBIT("Debit"),
    CREDIT("Credit");

    private final String type;

    TransactionType(String status) {
        this.type = status;
    }

    public String getStatus() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
