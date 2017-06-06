package model.income;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class IncomeAmount implements Serializable, Identifiable{
	private Integer value;

	public IncomeAmount(Integer value){ this.value = value; }
	public IncomeAmount(){ value = ID_EMPTY; }

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
		return String.format("IncomeAmount [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 2667565565656844086L;

}
