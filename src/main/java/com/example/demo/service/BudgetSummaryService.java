package com.example.demo.service;

import com.example.demo.model.BudgetSummary;
import java.util.List;

public interface BudgetSummaryService {
    BudgetSummary createBudgetSummary(BudgetSummary b);
    BudgetSummary getBudgetSummaryById(Long id);
    List<BudgetSummary> getAllBudgetSummaries();
    BudgetSummary updateBudgetSummary(Long id, BudgetSummary b);
    void deleteBudgetSummary(Long id);
}
