package model.dailybudget;

import java.io.Serializable;

public class DailyBudget implements Serializable{
	private DailyBudgetId dailyBudgetId;
	private DailyBudgetDate dailyBudgetDate;
	private Budget budget;

	public DailyBudget(DailyBudgetId dailyBudgetId, DailyBudgetDate dailyBudgetDate, Budget budge){
		this.dailyBudgetId = dailyBudgetId;
		this.dailyBudgetDate = dailyBudgetDate;
		this.budget = budge;
	}
	public DailyBudget(){
		dailyBudgetId = new DailyBudgetId();
		dailyBudgetDate = new DailyBudgetDate();
		budget = new Budget();
	}

	public DailyBudgetId dailyBudgetId(){
		return dailyBudgetId;
	}
	public Budget budget(){
		return budget;
	}
	@Deprecated
	public DailyBudgetId getDailyBudgetId(){
		return dailyBudgetId;
	}
	@Deprecated
	public DailyBudgetDate getDailyBudgetDate(){
		return dailyBudgetDate;
	}
	@Deprecated
	public Budget getBudget(){
		return budget;
	}

	@Override
	public String toString() {
		return String.format("DailyBudget [dailyBudgetId=%s, dailyBudgetDate=%s, budget=%s]", dailyBudgetId,
				dailyBudgetDate, budget);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -1560815526579705549L;

}
