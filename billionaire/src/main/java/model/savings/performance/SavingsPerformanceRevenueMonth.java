package model.savings.performance;

import java.io.Serializable;

public class SavingsPerformanceRevenueMonth implements Serializable{
	private String value;

	public SavingsPerformanceRevenueMonth(String value){
		this.value = value;
	}
	public SavingsPerformanceRevenueMonth(){
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
		return String.format("SavingsPerformanceRevenueMounth [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 6594980305948283322L;

}
