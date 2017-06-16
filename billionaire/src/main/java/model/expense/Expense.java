package model.expense;

import java.io.Serializable;

import javax.validation.Valid;

import model.expense.category.ExpenseCategory;

public class Expense implements Serializable{
	@Valid
	private ExpenseAmount expenseAmount;
	private ExpenseId expenseId;
	private ExpenseMemo expenseMemo;
	private ExpenseName expenseName;
	private ExpenseCategory expenseCategory;

	public Expense(ExpenseAmount expenseAmount, ExpenseId expenseId, ExpenseMemo expenseMemo,
											ExpenseName expenseName, String expenseCategory){
		this.expenseAmount = expenseAmount;
		this.expenseId = expenseId;
		this.expenseMemo = expenseMemo;
		this.expenseName = expenseName;
		this.expenseCategory = ExpenseCategory.valueOf(expenseCategory);
	}
	public Expense(){
		expenseAmount = new ExpenseAmount();
		expenseId = new ExpenseId();
		expenseMemo = new ExpenseMemo();
		expenseName = new ExpenseName();
		expenseCategory = ExpenseCategory.FOOD_EXPENSES;
	}

	public ExpenseId expenseId(){
		return expenseId;
	}
	public ExpenseAmount expenseAmount(){
		return expenseAmount;
	}
	@Deprecated
	public void setExpenseCategory(ExpenseCategory expenseCategory){
		this.expenseCategory = expenseCategory;
	}
	@Deprecated
	public ExpenseAmount getExpenseAmount(){
		return expenseAmount;
	}
	@Deprecated
	public ExpenseId getExpenseId(){
		return expenseId;
	}
	@Deprecated
	public ExpenseMemo getExpenseMemo(){
		return expenseMemo;
	}
	@Deprecated
	public ExpenseName getExpenseName(){
		return expenseName;
	}
	@Deprecated
	public ExpenseCategory getExpenseCategory(){
		return expenseCategory;
	}

	@Override
	public String toString() {
		return String.format(
				"Expense [expenseAmount=%s, expenseId=%s, expenseMemo=%s, expenseName=%s, expenseCategory=%s]",
				expenseAmount, expenseId, expenseMemo, expenseName, expenseCategory);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -2745397594395208829L;

}
