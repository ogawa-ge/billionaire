package model.expense;

import java.io.Serializable;

public class ExpenseName implements Serializable{
	private String value;

	public ExpenseName(String value){
		this.value = value;
	}
	public ExpenseName(){
		value = "";
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
		return String.format("ExpenseName [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -8821189416128100821L;

}
