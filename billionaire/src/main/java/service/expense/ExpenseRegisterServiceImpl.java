package service.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.dailybudget.DailyBudgetId;
import model.expense.Expense;
import model.expense.ExpenseRepository;

@Service("expenseRegisterService")
public class ExpenseRegisterServiceImpl implements ExpenseRegisterService{
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public void register(Expense expense, DailyBudgetId dailyBudgetId) {
		expenseRepository.register(expense, dailyBudgetId);
	}

}
