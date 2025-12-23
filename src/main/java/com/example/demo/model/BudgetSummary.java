package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BudgetSummary {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private BudgetPlan budgetPlan;

    private Double totalIncome;
    private Double totalExpense;
    private String status;
    private LocalDateTime generatedAt;

    public BudgetSummary() {}
}
