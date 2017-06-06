package model.savings.goal;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class SavingsGoalId implements Serializable, Identifiable{
	private Integer value;

	public SavingsGoalId(Integer value){
		this.value = value;
	}
	public SavingsGoalId(){
		value = ID_EMPTY;
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
		return String.format("SavingsGoalId [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 6100183218592586091L;

}
