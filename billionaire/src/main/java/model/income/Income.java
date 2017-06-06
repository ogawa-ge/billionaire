package model.income;

import java.io.Serializable;

public class Income implements Serializable{
	private IncomeAmount incomeAmount;
	private IncomeId incomeId;
	private IncomeRevenueDate incomeRevenueDate;

	public Income(IncomeAmount incomeAmount, IncomeId incomeId, IncomeRevenueDate incomeRevenueDate){
		this.incomeAmount = incomeAmount;
		this.incomeId = incomeId;
		this.incomeRevenueDate = incomeRevenueDate;
	}
	public Income(){
		incomeAmount = new IncomeAmount();
		incomeId = new IncomeId();
		incomeRevenueDate = new IncomeRevenueDate();
	}

	@Deprecated
	public IncomeAmount getIncomeAmount(){
		return incomeAmount;
	}
	@Deprecated
	public IncomeId getIncomeId(){
		return incomeId;
	}
	@Deprecated
	public IncomeRevenueDate getIncomeRevenueDate(){
		return incomeRevenueDate;
	}

	@Override
	public String toString() {
		return String.format("Income [incomeAmount=%s, incomeId=%s, incomeRevenueDate=%s]", incomeAmount, incomeId,
				incomeRevenueDate);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -2201378421284613436L;

}
