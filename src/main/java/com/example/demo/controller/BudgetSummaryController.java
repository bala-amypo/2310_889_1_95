@GetMapping("/{budgetPlanId}")
public BudgetSummary getByBudgetPlan(@PathVariable Long budgetPlanId) {

    return summaryRepo
            .findByBudgetPlanId(budgetPlanId)
            .orElse(null);
}
