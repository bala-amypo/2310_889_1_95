package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/summary")
public class BudgetSummaryController {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;

    public BudgetSummaryController(BudgetSummaryRepository summaryRepo,
                                   BudgetPlanRepository planRepo) {
        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
    }

    @PostMapping("/generate/{budgetPlanId}")
    public BudgetSummary generate(@PathVariable Long budgetPlanId) {

        BudgetPlan plan = planRepo.findById(budgetPlanId).orElse(null);

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);

        return summaryRepo.save(summary);
    }

    @GetMapping("/{budgetPlanId}")
    public BudgetSummary get(@PathVariable Long budgetPlanId) {
        return summaryRepo
                .findByBudgetPlanId(budgetPlanId)
                .orElse(null);
    }
}
