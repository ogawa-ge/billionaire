package service.dailybudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.dailybudget.Budget;
import model.dailybudget.DailyBudgetDate;
import model.dailybudget.DailyBudgetRepository;
import model.user.UserId;

@Service("dailyBudgetRegisterService")
public class DailyBudgetRegisterServiceImpl implements DailyBudgetRegisterService{
	@Autowired
	private DailyBudgetRepository dailyBudgetRepository;

	@Override
	public void register(UserId userId, DailyBudgetDate dailyBudgetDate, Budget budget) {
		dailyBudgetRepository.register(userId, dailyBudgetDate, budget);
	}

}
