package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;

@RestController
@RequestMapping("/summary")
@Tag(name = "Budget Summary APIs")
public class BudgetSummaryController {

    private final BudgetSummaryService service;

    public BudgetSummaryController(BudgetSummaryService service) {
        this.service = service;
    }

    @Operation(summary = "Generate summary")
    @PostMapping("/generate/{planId}")
    public BudgetSummary generate(@PathVariable Long planId) {
        return service.generate(planId);
    }

    @Operation(summary = "Get summary")
    @GetMapping("/{planId}")
    public BudgetSummary get(@PathVariable Long planId) {
        return service.get(planId);
    }
}
