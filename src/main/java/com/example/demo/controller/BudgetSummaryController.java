package com.example.demo.controller;

import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget-summaries")
public class BudgetSummaryController {

    private final BudgetSummaryRepository repository;

    public BudgetSummaryController(BudgetSummaryRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public BudgetSummary create(@RequestBody BudgetSummary summary) {
        return repository.save(summary);
    }

    @GetMapping
    public List<BudgetSummary> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BudgetSummary getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
