package com.example.demo.model;
import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "budget_plans")
@Data @NoArgsConstructor @AllArgsConstructor
public class BudgetPlan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne private User user;
    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;

    public void validate() {
        if (month < 1 || month > 12) throw new BadRequestException("Invalid month");
        if (incomeTarget < 0 || expenseLimit < 0) throw new BadRequestException("Targets must be non-negative");
    }
}