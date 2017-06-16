package service.dailybudget;

import model.dailybudget.DailyBudgetDate;
import model.user.UserId;

public interface DailyBudgetCheckService {
	public boolean isNotExists(UserId userId, DailyBudgetDate dailyBudgetDate);
	public boolean isExists(UserId userId, DailyBudgetDate dailyBudgetDate);
}
