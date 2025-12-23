package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budgets")
public class BudgetPlanController {

    private final BudgetPlanRepository budgetRepo;
    private final UserRepository userRepo;

    public BudgetPlanController(BudgetPlanRepository budgetRepo,
                                UserRepository userRepo) {
        this.budgetRepo = budgetRepo;
        this.userRepo = userRepo;
    }

    // POST /budgets/{userId}
    @PostMapping("/{userId}")
    public BudgetPlan createBudget(@PathVariable Long userId,
                                   @RequestBody BudgetPlan plan) {
        User user = userRepo.findById(userId).orElseThrow();
        plan.setUser(user);
        return budgetRepo.save(plan);
    }

    // GET /budgets/{userId}/{month}/{year}
    @GetMapping("/{userId}/{month}/{year}")
    public BudgetPlan getBudget(@PathVariable Long userId,
                                @PathVariable int month,
                                @PathVariable int year) {
        return budgetRepo.findByUserIdAndMonthAndYear(userId, month, year);
    }
}
