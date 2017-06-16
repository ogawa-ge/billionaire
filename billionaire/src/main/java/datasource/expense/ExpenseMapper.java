package datasource.expense;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.dailybudget.DailyBudgetId;
import model.expense.Expense;

public interface ExpenseMapper {
	public void register(@Param("expense") Expense expense, @Param("dailyBudgetId") DailyBudgetId dailyBudgetId);
	public List<Expense> listOf(@Param("dailyBudgetId") DailyBudgetId dailyBudgetId);
	public Integer findTotal(@Param("dailyBudgetId") DailyBudgetId dailyBudgetId);
	public Expense findBy(@Param("expenseId") Integer expenseId);
	public void modify(@Param("expense") Expense expense);
	public void delete(Integer expenseId);
}
