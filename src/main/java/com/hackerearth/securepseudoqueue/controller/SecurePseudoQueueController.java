package com.hackerearth.securepseudoqueue.controller;

import com.hackerearth.securepseudoqueue.entity.Transaction;
import com.hackerearth.securepseudoqueue.service.SecurePseudoQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurePseudoQueueController {

    @Autowired
    SecurePseudoQueueService service;

/*
    @PostMapping("/transaction/{accountNumber}/{type}/{amount}/{currency}/{accountFrom}")
    public Transaction addNewTransaction(@PathVariable String accountNumber,
                        @PathVariable String type,
                        @PathVariable String amount,
                        @PathVariable String currency,
                        @PathVariable String accountFrom) {

        Transaction transaction = new Transaction(
                Long.parseLong(accountNumber),
                type,
                Double.parseDouble(amount),
                currency,
                Long.parseLong(accountFrom)
        );
        String encryptedTransaction = service.encrypt(transaction);
        addToDB(encryptedTransaction);

        return transaction;
    }
*/

    @PostMapping("/transaction")
    @ResponseBody
    public String addNewTransaction(@RequestBody Transaction transaction) {

        String encryptedTransaction = service.encrypt(transaction);
        addToDB(encryptedTransaction);

        return encryptedTransaction;
    }

    public void addToDB(String encryptedTransaction) {
        service.decryptAndAddToDB(encryptedTransaction);
    }
}
