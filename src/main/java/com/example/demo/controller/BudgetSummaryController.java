package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.BudgetSummaryService;
import com.example.demo.service.impl.BudgetSummaryServiceImpl;

import java.util.Date;

public class BudgetSummaryController {
    public static void main(String[] args) {
        BudgetSummaryService service = new BudgetSummaryServiceImpl();

        User user = new User(1L, "Raj", "raj@gmail.com", "pass", "USER");
        BudgetPlan plan = new BudgetPlan(1L, user, 9, 2025, 70000, 30000);

        BudgetSummary summary =
                new BudgetSummary(1L, plan, 68000, 29000, "WITHIN_LIMIT", new Date());

        service.createBudgetSummary(summary);

        System.out.println(service.getBudgetSummaryById(1L).getStatus());

        summary.setStatus("EXCEEDED");
        service.updateBudgetSummary(1L, summary);

        service.getAllBudgetSummaries()
               .forEach(s -> System.out.println(s.getTotalExpense()));

        service.deleteBudgetSummary(1L);
    }
}
