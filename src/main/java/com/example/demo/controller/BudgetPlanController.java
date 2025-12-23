package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;

@RestController
@RequestMapping("/budgets")
@Tag(name = "Budget Plan APIs")
public class BudgetPlanController {

    private final BudgetPlanService service;

    public BudgetPlanController(BudgetPlanService service) {
        this.service = service;
    }

    @Operation(summary = "Create budget plan")
    @PostMapping("/{userId}")
    public BudgetPlan create(@PathVariable Long userId, @RequestBody BudgetPlan plan) {
        return service.create(userId, plan);
    }

    @Operation(summary = "Get budget plan")
    @GetMapping("/{userId}/{month}/{year}")
    public BudgetPlan get(@PathVariable Long userId,
                          @PathVariable Integer month,
                          @PathVariable Integer year) {
        return service.get(userId, month, year);
    }
}
