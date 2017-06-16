package model.expense;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("expenseListFactory")
public class ExpenseList implements Serializable{
	private List<Expense> expenseList;

	public ExpenseList(List<Expense> expenseList){
		this.expenseList = expenseList;
	}
	public ExpenseList(){
		expenseList = new ArrayList<Expense>();
	}

	@Deprecated
	public void setExpenseList(List<Expense> expenseList){
		this.expenseList = expenseList;
	}
	@Deprecated
	public List<Expense> getExpenseList(){
		return expenseList;
	}

	@Override
	public String toString() {
		return String.format("ExpenseList [expenseList=%s]", expenseList);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 7340921462770543676L;

}
