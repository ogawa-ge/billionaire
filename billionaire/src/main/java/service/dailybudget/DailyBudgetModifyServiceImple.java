package service.dailybudget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.dailybudget.DailyBudgetId;
import model.dailybudget.DailyBudgetRepository;
import model.expense.ExpenseAmount;

@Service("dailyBudgetModifyService")
public class DailyBudgetModifyServiceImple implements DailyBudgetModifyService{
	@Autowired
	private DailyBudgetRepository dailyBudgetRepository;

	@Override
	public void modify(DailyBudgetId dailyBudgetId, ExpenseAmount expenseAmount) {
		dailyBudgetRepository.modify(dailyBudgetId, expenseAmount);
	}

}
