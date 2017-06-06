package model.income;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class IncomeId implements Serializable, Identifiable{
	private Integer value;

	public IncomeId(Integer value){ this.value = value; }
	public IncomeId(){ value = ID_EMPTY; }

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
		return String.format("IncomeId [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = -5465955004802373068L;

}
