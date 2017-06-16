package service.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.expense.ExpenseRepository;

@Service("expenseDeleateService")
public class ExpenseDeleateServiceImpl implements ExpenseDeleateService{
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public void delete(Integer expenseId) {
		expenseRepository.delete(expenseId);
	}
}
