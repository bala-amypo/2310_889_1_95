package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget-plans")
public class BudgetPlanController {

    private final BudgetPlanRepository repository;

    public BudgetPlanController(BudgetPlanRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public BudgetPlan create(@RequestBody BudgetPlan plan) {
        return repository.save(plan);
    }

    @GetMapping
    public List<BudgetPlan> getAll() {
        return repository.findAll();
    }
}
