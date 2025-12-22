package com.example.demo.service;

import com.example.demo.model.BudgetPlan;
import java.util.List;

public interface BudgetPlanService {
    BudgetPlan createBudgetPlan(BudgetPlan b);
    BudgetPlan getBudgetPlanById(Long id);
    List<BudgetPlan> getAllBudgetPlans();
    BudgetPlan updateBudgetPlan(Long id, BudgetPlan b);
    void deleteBudgetPlan(Long id);
}
