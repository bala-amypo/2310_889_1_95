package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;
import java.time.YearMonth;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {
    private final BudgetSummaryRepository budgetSummaryRepository;
    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository bsr, BudgetPlanRepository bpr, TransactionLogRepository tlr) {
        this.budgetSummaryRepository = bsr;
        this.budgetPlanRepository = bpr;
        this.transactionLogRepository = tlr;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId).orElseThrow();
        YearMonth ym = YearMonth.of(plan.getYear(), plan.getMonth());
        List<TransactionLog> trans = transactionLogRepository.findByUserAndTransactionDateBetween(
                plan.getUser(), ym.atDay(1), ym.atEndOfMonth());

        double inc = trans.stream().filter(t -> Category.TYPE_INCOME.equals(t.getCategory().getType())).mapToDouble(TransactionLog::getAmount).sum();
        double exp = trans.stream().filter(t -> Category.TYPE_EXPENSE.equals(t.getCategory().getType())).mapToDouble(TransactionLog::getAmount).sum();

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(inc);
        summary.setTotalExpense(exp);
        summary.setStatus(exp <= plan.getExpenseLimit() ? BudgetSummary.STATUS_UNDER_LIMIT : BudgetSummary.STATUS_OVER_LIMIT);
        return budgetSummaryRepository.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId).orElseThrow();
        return budgetSummaryRepository.findByBudgetPlan(plan).orElse(null);
    }
}