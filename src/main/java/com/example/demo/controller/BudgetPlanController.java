@GetMapping("/search")
public BudgetPlan getByUserMonthYear(
        @RequestParam Long userId,
        @RequestParam int month,
        @RequestParam int year) {

    return budgetRepo
            .findByUserIdAndMonthAndYear(userId, month, year)
            .orElse(null);
}
