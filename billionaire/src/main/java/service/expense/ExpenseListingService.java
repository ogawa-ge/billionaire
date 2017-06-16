package service.expense;

import model.dailybudget.DailyBudgetId;
import model.expense.ExpenseList;

public interface ExpenseListingService {
	public ExpenseList listOf(DailyBudgetId dailyBudgetId);
	public Integer findTotal(DailyBudgetId dailyBudgetId);
}
