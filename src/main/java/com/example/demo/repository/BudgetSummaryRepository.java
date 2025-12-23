package com.example.demo.repository;

import com.example.demo.model.BudgetSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary, Long> {

    // Used by BudgetSummaryController
    Optional<BudgetSummary> findByBudgetPlanId(Long budgetPlanId);
}
