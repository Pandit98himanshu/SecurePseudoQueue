package com.hackerearth.securepseudoqueue.controller;

import com.hackerearth.securepseudoqueue.entity.Transaction;
import com.hackerearth.securepseudoqueue.service.SecurePseudoQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurePseudoQueueController {

    @Autowired
    SecurePseudoQueueService service;

    @PostMapping("/transaction/{accountNumber}/{type}/{amount}/{currency}/{accountFrom}")
    public void addNewTransaction(@PathVariable long accountNumber,
                        @PathVariable String type,
                        @PathVariable double amount,
                        @PathVariable String currency,
                        @PathVariable long accountFrom) {
        Transaction transaction = new Transaction(accountNumber, type, amount, currency, accountFrom);
        String encryptedTransaction = service.encrypt(transaction);
        addToDB(encryptedTransaction);
    }

    public void addToDB(String encryptedTransaction) {
        service.decryptAndAddToDB(encryptedTransaction);
    }
}
