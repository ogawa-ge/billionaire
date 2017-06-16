package model.expense;

import model.dailybudget.DailyBudgetId;

public interface ExpenseRepository {
	public void register(Expense expense, DailyBudgetId dailyBudgetId);
	public ExpenseList listOf(DailyBudgetId dailyBudgetId);
	public Integer findTotal(DailyBudgetId dailyBudgetId);
	public Expense findBy(Integer expenseId);
	public void modify(Expense expense);
	public void delete(Integer expenseId);
}
