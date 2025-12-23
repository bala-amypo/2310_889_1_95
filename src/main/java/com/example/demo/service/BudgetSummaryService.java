package com.example.demo.service;

import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryService {

    BudgetSummary save(BudgetSummary summary);

    BudgetSummary get(Long budgetPlanId);
}
