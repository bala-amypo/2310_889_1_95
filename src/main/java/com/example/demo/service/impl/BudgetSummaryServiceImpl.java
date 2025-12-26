package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.model.Category;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository budgetSummaryRepository;
    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository budgetSummaryRepository,
            BudgetPlanRepository budgetPlanRepository,
            TransactionLogRepository transactionLogRepository) {
        this.budgetSummaryRepository = budgetSummaryRepository;
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionLogRepository = transactionLogRepository;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
                .orElseThrow(() -> new RuntimeException("Budget plan not found"));

        YearMonth yearMonth = YearMonth.of(plan.getYear(), plan.getMonth());
        LocalDate start = yearMonth.atDay(1);
        LocalDate end = yearMonth.atEndOfMonth();

        List<TransactionLog> logs = transactionLogRepository.findByUserAndTransactionDateBetween(plan.getUser(), start,
                end);

        double totalIncome = logs.stream()
                .filter(log -> Category.TYPE_INCOME.equals(log.getCategory().getType()))
                .mapToDouble(TransactionLog::getAmount)
                .sum();

        double totalExpense = logs.stream()
                .filter(log -> Category.TYPE_EXPENSE.equals(log.getCategory().getType()))
                .mapToDouble(TransactionLog::getAmount)
                .sum();

        String status = totalExpense <= plan.getExpenseLimit()
                ? BudgetSummary.STATUS_UNDER_LIMIT
                : BudgetSummary.STATUS_OVER_LIMIT;

        BudgetSummary summary = budgetSummaryRepository.findByBudgetPlan(plan)
                .orElse(new BudgetSummary());

        summary.setBudgetPlan(plan);
        summary.setTotalIncome(totalIncome);
        summary.setTotalExpense(totalExpense);
        summary.setStatus(status);

        // generatedAt is handled by @PrePersist on create, but if it exists we might
        // want to update it?
        // Spec says "Lifecycle method onCreate() initializes generatedAt when the
        // entity is first persisted."
        // Using JPA, @PrePersist only runs on insert. If we update, we might want to
        // update it check if requirements say anything.
        // Spec: "Lifecycle method onCreate() initializes generatedAt when the entity is
        // first persisted" - implies create only.

        return budgetSummaryRepository.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
                .orElseThrow(() -> new RuntimeException("Budget plan not found"));
        return budgetSummaryRepository.findByBudgetPlan(plan).orElse(null);
    }
}
