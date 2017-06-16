package datasource.dailybudget;

import org.apache.ibatis.annotations.Param;

import model.calendar.CalendarDailyDetail;
import model.dailybudget.Budget;
import model.dailybudget.DailyBudget;
import model.dailybudget.DailyBudgetDate;
import model.dailybudget.DailyBudgetId;
import model.expense.ExpenseAmount;
import model.user.UserId;

public interface DailyBudgetMapper {
	public DailyBudget findBy(@Param("userId") UserId userId, @Param("dailyBudgetDate") DailyBudgetDate dailyBudgetDate);
	public void register(@Param("userId") UserId userId, @Param("dailyBudgetDate") DailyBudgetDate dailyBudgetDate, @Param("budget") Budget budget);
	public void modify(@Param("dailyBudgetId") DailyBudgetId dailyBudgetId, @Param("expenseAmount") ExpenseAmount expenseAmount);
	public DailyBudgetId findLastId(@Param("userId") UserId userId);
	public CalendarDailyDetail listOf(@Param("userId") UserId userId, @Param("date") String date);
}
