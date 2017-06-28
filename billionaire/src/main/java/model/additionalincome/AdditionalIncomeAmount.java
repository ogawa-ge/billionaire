package model.additionalincome;

import java.io.Serializable;

public class AdditionalIncomeAmount implements Serializable{
	private String value;

	public AdditionalIncomeAmount(String value){
		this.value = value;
	}
	public AdditionalIncomeAmount(){
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
		return String.format("AdditionalIncomeAmount [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 5414150166258344617L;

}
