package com.hackerearth.securepseudoqueue.service;

import com.hackerearth.securepseudoqueue.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class SecurePseudoQueueService {

    @Autowired
    EntityManager entityManager;

    public String encrypt(Transaction transaction) {
        return null;
    }

    public void decryptAndAddToDB(String data) {
        Transaction transaction = null;
        addToDB(transaction);
    }

    public void addToDB(Transaction transaction) {
        entityManager.persist(transaction);
    }
}
