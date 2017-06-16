package service.expense;

import model.expense.Expense;

public interface ExpenseFindService {
	public Expense findBy(Integer expenseId);
}
