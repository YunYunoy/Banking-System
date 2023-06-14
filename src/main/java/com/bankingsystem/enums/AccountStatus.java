package com.bankingsystem.enums;

public enum AccountStatus {
    ACTIVE("Active"),
    CLOSED("Closed"),
    FROZEN("Frozen"),
    BLOCKED("Blocked");

    private final String status;

    AccountStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}