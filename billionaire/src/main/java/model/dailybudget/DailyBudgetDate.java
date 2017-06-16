package model.dailybudget;

import java.io.Serializable;

public class DailyBudgetDate implements Serializable{
	private String value;

	public DailyBudgetDate(String value){
		this.value = value;
	}
	public DailyBudgetDate(){
		value = "---";
	}

	@Deprecated
	public void setValue(String value){
		this.value = value;
	}
	@Deprecated
	public String getValue(){
		return value;
	}

	@Override
	public String toString() {
		return String.format("DailyBudgetDate [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -7794631012135016124L;

}
