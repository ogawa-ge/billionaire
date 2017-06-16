package service.dailybudget;

import model.dailybudget.DailyBudget;
import model.dailybudget.DailyBudgetDate;
import model.dailybudget.DailyBudgetId;
import model.user.UserId;

public interface DailyBudgetFindService {
	public DailyBudget findBy(UserId userId, DailyBudgetDate dailyBudgetDate);
	public DailyBudgetId findLastId(UserId userId);
}
