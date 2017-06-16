package service.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.dailybudget.DailyBudgetId;
import model.expense.ExpenseList;
import model.expense.ExpenseRepository;

@Service("expenseListingService")
public class ExpenseListingServiceImpl implements ExpenseListingService{
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public ExpenseList listOf(DailyBudgetId dailyBudgetId) {
		return expenseRepository.listOf(dailyBudgetId);
	}

	@Override
	public Integer findTotal(DailyBudgetId dailyBudgetId) {
		return expenseRepository.findTotal(dailyBudgetId);
	}
}
