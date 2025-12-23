package com.example.demo.service;

import com.example.demo.model.TransactionLog;
import java.util.List;

public interface TransactionLogService {
    TransactionLog createTransaction(TransactionLog t);
    TransactionLog getTransactionById(Long id);
    List<TransactionLog> getAllTransactions();
    TransactionLog updateTransaction(Long id, TransactionLog t);
    void deleteTransaction(Long id);
}
