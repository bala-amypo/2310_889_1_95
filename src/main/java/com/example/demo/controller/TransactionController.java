package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
@Tag(name = "Transaction APIs")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @Operation(summary = "Add transaction")
    @PostMapping("/{userId}")
    public TransactionLog add(@PathVariable Long userId, @RequestBody TransactionLog log) {
        return service.add(userId, log);
    }

    @Operation(summary = "Get user transactions")
    @GetMapping("/user/{userId}")
    public List<TransactionLog> get(@PathVariable Long userId) {
        return service.getByUser(userId);
    }
}
