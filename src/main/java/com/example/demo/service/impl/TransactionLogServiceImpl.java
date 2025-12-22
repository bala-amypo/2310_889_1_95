package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionLogService;
import java.util.List;

public class TransactionLogServiceImpl implements TransactionLogService {
    private final TransactionLogRepository repo = new TransactionLogRepository();

    public TransactionLog createTransaction(TransactionLog t) { return repo.save(t); }
    public TransactionLog getTransactionById(Long id) { return repo.findById(id); }
    public List<TransactionLog> getAllTransactions() { return repo.findAll(); }
    public TransactionLog updateTransaction(Long id, TransactionLog t) { return repo.update(id, t); }
    public void deleteTransaction(Long id) { repo.deleteById(id); }
}
