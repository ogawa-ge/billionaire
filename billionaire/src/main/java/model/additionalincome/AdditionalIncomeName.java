package model.additionalincome;

import java.io.Serializable;

public class AdditionalIncomeName implements Serializable{
	private String value;

	public AdditionalIncomeName(String value){
		this.value = value;
	}
	public AdditionalIncomeName(){
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
		return String.format("AdditionalIncomeName [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -5096363942903922777L;

}
