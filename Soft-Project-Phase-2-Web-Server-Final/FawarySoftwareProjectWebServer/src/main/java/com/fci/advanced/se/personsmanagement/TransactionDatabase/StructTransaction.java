package com.fci.advanced.se.personsmanagement.TransactionDatabase;

public class StructTransaction {
    private TransactionType transactionType;
    private float money;
    public StructTransaction(TransactionType transactionType, float money) {
        this.transactionType = transactionType;
        this.money = money;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public float getMoney() {
        return money;
    }
}
