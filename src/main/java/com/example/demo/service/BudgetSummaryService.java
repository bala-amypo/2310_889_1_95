package com.example.demo.service;

import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryService {
    BudgetSummary generate(Long budgetPlanId);
    BudgetSummary get(Long budgetPlanId);
}
