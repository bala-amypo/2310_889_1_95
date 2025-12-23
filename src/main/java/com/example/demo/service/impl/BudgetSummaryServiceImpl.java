package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository repo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository repo) {
        this.repo = repo;
    }

    @Override
    public BudgetSummary getByBudgetPlan(BudgetPlan plan) {
        return repo
                .findByBudgetPlanId(plan.getId())
                .orElse(null);
    }

    @Override
    public BudgetSummary save(BudgetSummary summary) {
        return repo.save(summary);
    }
}
