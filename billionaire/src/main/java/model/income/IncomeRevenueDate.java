package model.income;

import java.io.Serializable;

public class IncomeRevenueDate implements Serializable{
	private String value;

	public IncomeRevenueDate(String value){ this.value = value; }
	public IncomeRevenueDate(){ value = ""; }

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
		return String.format("IncomeAmount [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = 8156792380587489846L;

}
