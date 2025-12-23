package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budgets")
public class BudgetPlanController {

    private final BudgetPlanRepository repo;
    private final UserRepository userRepo;

    public BudgetPlanController(BudgetPlanRepository repo,
                                UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @PostMapping("/{userId}")
    public BudgetPlan create(@PathVariable Long userId,
                             @RequestBody BudgetPlan plan) {

        User user = userRepo.findById(userId).orElse(null);
        plan.setUser(user);
        return repo.save(plan);
    }

    @GetMapping("/{userId}/{month}/{year}")
    public BudgetPlan get(
            @PathVariable Long userId,
            @PathVariable int month,
            @PathVariable int year) {

        return repo
                .findByUserIdAndMonthAndYear(userId, month, year)
                .orElse(null);
    }
}
