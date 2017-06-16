package datasource.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.dailybudget.DailyBudgetId;
import model.expense.Expense;
import model.expense.ExpenseList;
import model.expense.ExpenseRepository;

@Repository("expenseRepository")
public class ExpenseDataAccese implements ExpenseRepository{
	@Autowired
	private ExpenseMapper expenseMapper;

	@Override
	public void register(Expense expense, DailyBudgetId dailyBudgetId) {
		expenseMapper.register(expense, dailyBudgetId);
	}

	@Override
	public ExpenseList listOf(DailyBudgetId dailyBudgetId) {
		return new ExpenseList(expenseMapper.listOf(dailyBudgetId));
	}

	@Override
	public Integer findTotal(DailyBudgetId dailyBudgetId) {
		return expenseMapper.findTotal(dailyBudgetId);
	}

	@Override
	public Expense findBy(Integer expenseId) {
		return expenseMapper.findBy(expenseId);
	}

	@Override
	public void modify(Expense expense) {
		expenseMapper.modify(expense);
	}

	@Override
	public void delete(Integer expenseId) {
		expenseMapper.delete(expenseId);
	}

}
