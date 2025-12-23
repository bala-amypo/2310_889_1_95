package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
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
