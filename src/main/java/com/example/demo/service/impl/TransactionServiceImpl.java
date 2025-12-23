package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repo;
    private final UserRepository userRepo;

    public TransactionServiceImpl(TransactionLogRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public TransactionLog add(Long userId, TransactionLog log) {
        User user = userRepo.findById(userId).orElseThrow();
        log.setUser(user);
        return repo.save(log);
    }

    public List<TransactionLog> getByUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return repo.findByUser(user);
    }
}
