package com.hackerearth.securepseudoqueue.controller;

import com.hackerearth.securepseudoqueue.entity.Transaction;
import com.hackerearth.securepseudoqueue.service.SecurePseudoQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurePseudoQueueController {

    @Autowired
    SecurePseudoQueueService service;

    @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    @ResponseBody
    public String addNewTransaction(@RequestBody Transaction transaction) {
        String encryptedTransaction = service.encrypt(transaction);

        service.decryptAndAddToDB(encryptedTransaction);

        return encryptedTransaction;
    }

    @RequestMapping(value = "/addtodb", method = RequestMethod.POST)
    @ResponseBody
    public void addToDB(@RequestBody Transaction transaction) {
        service.addToDB(transaction);
    }


}
