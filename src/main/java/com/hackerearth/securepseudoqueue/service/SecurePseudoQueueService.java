package com.hackerearth.securepseudoqueue.service;

import com.hackerearth.securepseudoqueue.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
public class SecurePseudoQueueService {

    @Autowired
    EntityManager entityManager;

    public String encrypt(Transaction transaction) {
        String encryptedTransaction = transaction.toString();
        return encryptedTransaction;
    }

    public Transaction decrypt(String data) {
        String[] datas = data.split("-");
        long accountNumber = Long.parseLong(datas[0]);
        String type = datas[1];
        double amount = Double.parseDouble(datas[2]);
        String currency = datas[3];
        long accountFrom = Long.parseLong(datas[4]);

        return new Transaction(accountNumber, type, amount, currency, accountFrom);
    }

    public void decryptAndAddToDB(String data) {
        Transaction transaction = decrypt(data);
        addToDB(transaction);
    }

    public void addToDB(Transaction transaction) {
        entityManager.persist(transaction);
    }
}
