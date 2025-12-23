package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository repo;
    private final BudgetPlanRepository planRepo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository repo, BudgetPlanRepository planRepo) {
        this.repo = repo;
        this.planRepo = planRepo;
    }

    public BudgetSummary generate(Long planId) {
        BudgetPlan plan = planRepo.findById(planId).orElseThrow();
        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(0.0);
        summary.setTotalExpense(0.0);
        summary.setStatus("UNDER_LIMIT");
        summary.setGeneratedAt(LocalDateTime.now());
        return repo.save(summary);
    }

    public BudgetSummary get(Long planId) {
        BudgetPlan plan = planRepo.findById(planId).orElseThrow();
        return repo.findByBudgetPlan(plan).orElseThrow();
    }
}
