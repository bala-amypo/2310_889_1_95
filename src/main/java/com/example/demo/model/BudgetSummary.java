package com.example.demo.model;

import java.util.Date;

public class BudgetSummary {
    private Long id;
    private BudgetPlan budgetPlan;
    private double totalIncome;
    private double totalExpense;
    private String status; // within limit / exceeded
    private Date generatedAt;

    public BudgetSummary() {}
    public BudgetSummary(Long id, BudgetPlan budgetPlan, double totalIncome, double totalExpense, String status, Date generatedAt) {
        this.id = id; this.budgetPlan = budgetPlan; this.totalIncome = totalIncome; this.totalExpense = totalExpense;
        this.status = status; this.generatedAt = generatedAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public void setBudgetPlan(BudgetPlan budgetPlan) { this.budgetPlan = budgetPlan; }

    public double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(double totalIncome) { this.totalIncome = totalIncome; }

    public double getTotalExpense() { return totalExpense; }
    public void setTotalExpense(double totalExpense) { this.totalExpense = totalExpense; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(Date generatedAt) { this.generatedAt = generatedAt; }
}
