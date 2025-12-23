package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionLogRepository transactionRepo;
    private final UserRepository userRepo;

    public TransactionController(TransactionLogRepository transactionRepo,
                                 UserRepository userRepo) {
        this.transactionRepo = transactionRepo;
        this.userRepo = userRepo;
    }

    // POST /transactions/{userId}
    @PostMapping("/{userId}")
    public TransactionLog addTransaction(@PathVariable Long userId,
                                         @RequestBody TransactionLog tx) {
        User user = userRepo.findById(userId).orElseThrow();
        tx.setUser(user);
        return transactionRepo.save(tx);
    }

    // GET /transactions/user/{userId}
    @GetMapping("/user/{userId}")
    public List<TransactionLog> getUserTransactions(@PathVariable Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        return transactionRepo.findByUser(user);
    }
}
