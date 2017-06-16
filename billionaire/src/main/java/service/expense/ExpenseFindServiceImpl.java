package service.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.expense.Expense;
import model.expense.ExpenseRepository;

@Service("expenseFindService")
public class ExpenseFindServiceImpl implements ExpenseFindService{
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public Expense findBy(Integer expenseId) {
		return expenseRepository.findBy(expenseId);
	}

}
