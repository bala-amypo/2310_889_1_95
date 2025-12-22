package com.example.demo.model;

public class BudgetPlan {
    private Long id;
    private User user;
    private int month;
    private int year;
    private double incomeTarget;
    private double expenseLimit;

    public BudgetPlan() {}
    public BudgetPlan(Long id, User user, int month, int year, double incomeTarget, double expenseLimit) {
        this.id = id; this.user = user; this.month = month; this.year = year; 
        this.incomeTarget = incomeTarget; this.expenseLimit = expenseLimit;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getIncomeTarget() { return incomeTarget; }
    public void setIncomeTarget(double incomeTarget) { this.incomeTarget = incomeTarget; }

    public double getExpenseLimit() { return expenseLimit; }
    public void setExpenseLimit(double expenseLimit) { this.expenseLimit = expenseLimit; }
}
