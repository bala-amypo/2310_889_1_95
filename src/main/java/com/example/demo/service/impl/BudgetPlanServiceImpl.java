package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.repository.*;
import com.example.demo.model.*;
import com.example.demo.service.BudgetPlanService;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repo;
    private final UserRepository userRepo;

    public BudgetPlanServiceImpl(BudgetPlanRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public BudgetPlan create(Long userId, BudgetPlan plan) {
        User user = userRepo.findById(userId).orElseThrow();
        plan.setUser(user);
        return repo.save(plan);
    }

    public BudgetPlan get(Long userId, Integer month, Integer year) {
        User user = userRepo.findById(userId).orElseThrow();
        return repo.findByUserAndMonthAndYear(user, month, year).orElseThrow();
    }
}
