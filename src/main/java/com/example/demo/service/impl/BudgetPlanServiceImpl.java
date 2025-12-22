package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;
import java.util.List;

public class BudgetPlanServiceImpl implements BudgetPlanService {
    private final BudgetPlanRepository repo = new BudgetPlanRepository();

    public BudgetPlan createBudgetPlan(BudgetPlan b) { return repo.save(b); }
    public BudgetPlan getBudgetPlanById(Long id) { return repo.findById(id); }
    public List<BudgetPlan> getAllBudgetPlans() { return repo.findAll(); }
    public BudgetPlan updateBudgetPlan(Long id, BudgetPlan b) { return repo.update(id, b); }
    public void deleteBudgetPlan(Long id) { repo.deleteById(id); }
}
