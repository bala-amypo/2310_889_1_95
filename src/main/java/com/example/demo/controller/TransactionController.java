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

    @PostMapping("/{userId}")
    public TransactionLog create(@PathVariable Long userId,
                                 @RequestBody TransactionLog log) {

        User user = userRepo.findById(userId).orElse(null);
        log.setUser(user);
        return transactionRepo.save(log);
    }

    @GetMapping("/user/{userId}")
    public List<TransactionLog> getByUser(@PathVariable Long userId) {
        User user = userRepo.findById(userId).orElse(null);
        return transactionRepo.findByUser(user);
    }
}
