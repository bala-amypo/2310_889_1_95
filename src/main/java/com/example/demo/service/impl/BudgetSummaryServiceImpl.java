package com.example.demo.service.impl;

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
    public BudgetSummary save(BudgetSummary summary) {
        return repo.save(summary);
    }

    @Override
    public BudgetSummary get(Long budgetPlanId) {
        return repo
                .findByBudgetPlanId(budgetPlanId)
                .orElse(null);
    }
}
