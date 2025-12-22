package com.example.demo.model;

import java.util.Date;

public class TransactionLog {
    private Long id;
    private User user;
    private Category category;
    private double amount;
    private String description;
    private Date transactionDate;

    public TransactionLog() {}
    public TransactionLog(Long id, User user, Category category, double amount, String description, Date transactionDate) {
        this.id = id; this.user = user; this.category = category;
        this.amount = amount; this.description = description; this.transactionDate = transactionDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getTransactionDate() { return transactionDate; }
    public void setTransactionDate(Date transactionDate) { this.transactionDate = transactionDate; }
}
