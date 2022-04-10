package com.hackerearth.securepseudoqueue.entity;

import lombok.*;

import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "TRANSACTIONS")
public class Transaction {
    private long accountNumber;
    private String type;
    private double amount;
    private String currency;
    private long accountFrom;
}
