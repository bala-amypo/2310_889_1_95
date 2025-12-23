package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.TransactionLogService;
import com.example.demo.service.impl.TransactionLogServiceImpl;

import java.util.Date;

public class TransactionLogController {
    public static void main(String[] args) {
        TransactionLogService service = new TransactionLogServiceImpl();

        User user = new User(1L, "Bob", "bob@gmail.com", "pass", "USER");
        Category cat = new Category(1L, "Salary", "INCOME");

        TransactionLog t = new TransactionLog(1L, user, cat, 50000, "Monthly Salary", new Date());
        service.createTransaction(t);

        System.out.println(service.getTransactionById(1L).getAmount());

        t.setAmount(52000);
        service.updateTransaction(1L, t);

        service.getAllTransactions().forEach(tx -> System.out.println(tx.getDescription()));
        service.deleteTransaction(1L);
    }
}
