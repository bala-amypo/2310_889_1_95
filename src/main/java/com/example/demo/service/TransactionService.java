package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TransactionLog;

public interface TransactionService {
    TransactionLog add(Long userId, TransactionLog log);
    List<TransactionLog> getByUser(Long userId);
}
