package model.expense;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class ExpenseId implements Serializable, Identifiable{
	private Integer value;

	public ExpenseId(Integer value){
		this.value = value;
	}
	public ExpenseId(){
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
		return String.format("ExpenseId [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 2972020482892448920L;

}
