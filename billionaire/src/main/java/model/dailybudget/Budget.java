package model.dailybudget;

import java.io.Serializable;

public class Budget implements Serializable{
	private String value;

	public Budget(String value){
		this.value = value;
	}
	public Budget(){
		value = "---";
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
		return String.format("Budget [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -847020172970751052L;

}
