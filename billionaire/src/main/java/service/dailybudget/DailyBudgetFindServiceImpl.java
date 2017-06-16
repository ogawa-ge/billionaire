package service.dailybudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.dailybudget.DailyBudget;
import model.dailybudget.DailyBudgetDate;
import model.dailybudget.DailyBudgetId;
import model.dailybudget.DailyBudgetRepository;
import model.user.UserId;

@Service("dailyBudgetFindService")
public class DailyBudgetFindServiceImpl implements DailyBudgetFindService{
	@Autowired
	private DailyBudgetRepository dailyBudgetRepository;

	@Override
	public DailyBudget findBy(UserId userId, DailyBudgetDate dailyBudgetDate) {
		return dailyBudgetRepository.findBy(userId, dailyBudgetDate);
	}

	@Override
	public DailyBudgetId findLastId(UserId userId) {
		return dailyBudgetRepository.findLastId(userId);
	}

}
