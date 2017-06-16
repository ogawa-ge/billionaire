package service.dailybudget;

import model.dailybudget.DailyBudgetId;
import model.expense.ExpenseAmount;

public interface DailyBudgetModifyService {
	public void modify(DailyBudgetId dailyBudgetId, ExpenseAmount expenseAmount);
}
