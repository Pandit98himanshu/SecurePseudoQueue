package com.hackerearth.securepseudoqueue.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "TRANSACTIONS")
public class Transaction {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long accountNumber;
    private String type;
    private double amount;
    private String currency;
    private long accountFrom;

    public Transaction(long accountNumber, String type, double amount, String currency, long accountFrom) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.currency = currency;
        this.accountFrom = accountFrom;
    }

    @Override
    public String toString() {
        return accountNumber + "-" + type + "-" + amount + "-" + currency + "-" + accountFrom;
    }
}
