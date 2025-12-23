package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repo;

    public BudgetPlanServiceImpl(BudgetPlanRepository repo) {
        this.repo = repo;
    }

    @Override
    public BudgetPlan save(BudgetPlan plan) {
        return repo.save(plan);
    }

    @Override
    public BudgetPlan get(Long userId, Integer month, Integer year) {
        return repo
                .findByUserIdAndMonthAndYear(userId, month, year)
                .orElse(null);
    }
}
