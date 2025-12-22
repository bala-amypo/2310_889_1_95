package com.example.demo.service.impl;

import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;
import java.util.List;

public class BudgetSummaryServiceImpl implements BudgetSummaryService {
    private final BudgetSummaryRepository repo = new BudgetSummaryRepository();

    public BudgetSummary createBudgetSummary(BudgetSummary b) { return repo.save(b); }
    public BudgetSummary getBudgetSummaryById(Long id) { return repo.findById(id); }
    public List<BudgetSummary> getAllBudgetSummaries() { return repo.findAll(); }
    public BudgetSummary updateBudgetSummary(Long id, BudgetSummary b) { return repo.update(id, b); }
    public void deleteBudgetSummary(Long id) { repo.deleteById(id); }
}
