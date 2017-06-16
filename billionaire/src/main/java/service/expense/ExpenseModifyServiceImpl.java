package service.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.expense.Expense;
import model.expense.ExpenseRepository;

@Service("expenseModifyService")
public class ExpenseModifyServiceImpl implements ExpenseModifyService{
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public void modify(Expense expense) {
		expenseRepository.modify(expense);
	}

}
