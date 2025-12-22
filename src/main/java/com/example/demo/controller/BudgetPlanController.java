package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.BudgetPlanService;
import com.example.demo.service.impl.BudgetPlanServiceImpl;

public class BudgetPlanController {
    public static void main(String[] args) {
        BudgetPlanService service = new BudgetPlanServiceImpl();

        User user = new User(1L, "Sam", "sam@gmail.com", "pass", "USER");

        BudgetPlan plan = new BudgetPlan(1L, user, 9, 2025, 80000, 40000);
        service.createBudgetPlan(plan);

        System.out.println(service.getBudgetPlanById(1L).getIncomeTarget());

        plan.setExpenseLimit(35000);
        service.updateBudgetPlan(1L, plan);

        service.getAllBudgetPlans().forEach(p -> System.out.println(p.getMonth()));
        service.deleteBudgetPlan(1L);
    }
}
