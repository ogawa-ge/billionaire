package model.additionalincome;

import java.io.Serializable;

public class AdditionalIncomeAddDate implements Serializable{
	private String value;

	public AdditionalIncomeAddDate(String value){
		this.value = value;
	}
	public AdditionalIncomeAddDate(){
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
		return String.format("AdditionalIncomeAddDate [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -6193447379588111293L;

}
