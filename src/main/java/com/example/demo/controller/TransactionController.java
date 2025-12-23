package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionLogRepository repository;

    public TransactionController(TransactionLogRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public TransactionLog create(@RequestBody TransactionLog log) {
        return repository.save(log);
    }

    @GetMapping
    public List<TransactionLog> getAll() {
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
