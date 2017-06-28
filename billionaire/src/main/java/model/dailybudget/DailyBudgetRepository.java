package model.dailybudget;

import model.calendar.CalendarList;
import model.expense.ExpenseAmount;
import model.user.UserId;

public interface DailyBudgetRepository {
	public DailyBudget findBy(UserId userId, DailyBudgetDate dailyBudgetDate);
	public void register(UserId userId, DailyBudgetDate dailyBudgetDate, Budget budget);
	public void modify(DailyBudgetId dailyBudgetId, ExpenseAmount expenseAmount);
	public DailyBudgetId findLastId(UserId userId);
	public CalendarList listOf(UserId userId, Integer value);
}
