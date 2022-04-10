package com.hackerearth.securepseudoqueue.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ACCOUNT_NUMBER")
    private long accountNumber;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "AMOUNT")
    private double amount;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "ACCOUNT_FROM")
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
