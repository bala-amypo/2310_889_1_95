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

    // POST /summary/generate/{budgetPlanId}
    @PostMapping("/generate/{budgetPlanId}")
    public BudgetSummary generateSummary(@PathVariable Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId).orElseThrow();

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(plan.getIncomeTarget());
        summary.setTotalExpense(plan.getExpenseLimit());

        return summaryRepo.save(summary);
    }

    // GET /summary/{budgetPlanId}
    @GetMapping("/{budgetPlanId}")
    public BudgetSummary getSummary(@PathVariable Long budgetPlanId) {
        return summaryRepo.findByBudgetPlanId(budgetPlanId);
    }
}
