package com.hackerearth.securepseudoqueue.service;

import com.hackerearth.securepseudoqueue.dao.TransactionRepo;
import com.hackerearth.securepseudoqueue.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Arrays;

@Service
@Transactional
public class SecurePseudoQueueService {

    @Autowired
    TransactionRepo repo;
    RestTemplate restTemplate = new RestTemplate();
    public static final String ADD_TO_DB = "http://localhost:8080/addtodb";

    public String encrypt(Transaction transaction) {
        // encrypting object data
        String encryptedTransaction = transaction.toString();

        decryptAndAddToDB(encryptedTransaction);

        System.out.println("Encrypted data = " + encryptedTransaction);
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

    public void addToDB(Transaction transaction) {
        repo.save(transaction);
    }

    private Transaction callAddToDBAPI(Transaction transaction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Transaction> entity = new HttpEntity<Transaction>(transaction, headers);

        ResponseEntity<Transaction> tr = restTemplate.exchange(ADD_TO_DB, HttpMethod.POST, entity, Transaction.class);
        System.out.println("ResponseEntity: " + tr.getBody());
        return tr.getBody();
    }

    public void decryptAndAddToDB(String encryptedTransaction) {
        Transaction transaction = decrypt(encryptedTransaction);
        callAddToDBAPI(transaction);
    }
}
