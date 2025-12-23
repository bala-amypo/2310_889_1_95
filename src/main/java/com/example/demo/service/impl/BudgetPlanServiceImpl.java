package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repo;
    private final UserRepository userRepo;

    public BudgetPlanServiceImpl(BudgetPlanRepository repo,
                                 UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @Override
    public BudgetPlan create(Long userId, BudgetPlan plan) {
        User user = userRepo.findById(userId).orElse(null);
        plan.setUser(user);   // ✅ correct
        return repo.save(plan);
    }

    @Override
    public BudgetPlan get(Long userId, Integer month, Integer year) {
        return repo
                .findByUserIdAndMonthAndYear(userId, month, year)
                .orElse(null);
    }
}
