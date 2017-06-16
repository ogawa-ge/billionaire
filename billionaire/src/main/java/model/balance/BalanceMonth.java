package model.balance;

import java.io.Serializable;

public class BalanceMonth implements Serializable{
	private String value;

	public BalanceMonth(String value){
		this.value = value;
	}
	public BalanceMonth(){
		value = "";
	}

	public String value(){
		return value;
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
		return String.format("BalanceMonth [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = -6783372977987700195L;

}
