package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

public interface BudgetPlanService {
    BudgetPlan create(Long userId, BudgetPlan plan);
    BudgetPlan get(Long userId, Integer month, Integer year);
}
