package model.savings.performance;

import java.io.Serializable;

public class SavingsPerformanceAmount implements Serializable{
	private String value;

	public SavingsPerformanceAmount(String value){
		this.value = value;
	}
	public SavingsPerformanceAmount(){
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
		return String.format("SavingsPerformanceAmount [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 8449497939238057644L;

}
