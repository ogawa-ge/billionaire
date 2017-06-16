package service.dailybudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.dailybudget.DailyBudgetDate;
import model.dailybudget.DailyBudgetRepository;
import model.user.UserId;

@Service("dailyBudgetCheckService")
public class DailyBudgetCheckServiceImpl implements DailyBudgetCheckService{
	@Autowired
	private DailyBudgetRepository dailyBudgetRepository;

	@Override
	public boolean isNotExists(UserId userId, DailyBudgetDate dailyBudgetDate) {
		return dailyBudgetRepository.findBy(userId, dailyBudgetDate) == null;
	}

	@Override
	public boolean isExists(UserId userId, DailyBudgetDate dailyBudgetDate) {
		return !isNotExists(userId, dailyBudgetDate);
	}

}
