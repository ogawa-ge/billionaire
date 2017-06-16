package service.dailybudget;

import model.dailybudget.Budget;
import model.dailybudget.DailyBudgetDate;
import model.user.UserId;

public interface DailyBudgetRegisterService {
	public void register(UserId userId, DailyBudgetDate dailyBudgetDate, Budget budget);
}
