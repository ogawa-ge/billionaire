package model.expense;

import org.springframework.stereotype.Component;

@Component("expenseFactory")
public class ExpenseFactory {
	public Expense create(){
		return new Expense();
	}
}
