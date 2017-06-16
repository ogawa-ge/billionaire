package model.dailybudget;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class DailyBudgetId implements Serializable, Identifiable{
	private Integer value;

	public DailyBudgetId(Integer value){
		this.value = value;
	}
	public DailyBudgetId(){
		value = ID_EMPTY;
	}

	public Integer value(){
		return value;
	}
	@Deprecated
	public void setValue(Integer value){
		this.value = value;
	}
	@Deprecated
	public Integer getValue(){
		return value;
	}

	@Override
	public String toString() {
		return String.format("DailyBudgetId [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -80893799172404516L;

}
