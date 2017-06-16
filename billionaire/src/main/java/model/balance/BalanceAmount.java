package model.balance;

import java.io.Serializable;

public class BalanceAmount implements Serializable{
	private String value;

	public BalanceAmount(String value){
		this.value = value;
	}
	public BalanceAmount(){
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
		return String.format("BalanceAmount [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = -3028857810784529074L;

}
