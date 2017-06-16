package service.expense;

import model.dailybudget.DailyBudgetId;
import model.expense.Expense;

public interface ExpenseRegisterService {
	public void register(Expense expense, DailyBudgetId dailyBudgetId);
}
