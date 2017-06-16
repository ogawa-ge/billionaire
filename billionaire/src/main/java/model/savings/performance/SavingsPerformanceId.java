package model.savings.performance;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class SavingsPerformanceId implements Serializable, Identifiable{
	private Integer value;

	public SavingsPerformanceId(Integer value){
		this.value = value;
	}
	public SavingsPerformanceId(){
		value = ID_EMPTY;
	}

	@Deprecated
	public void setValue(Integer value){
		this.value = value;

	}
	@Deprecated
	public Integer getValue(){
		return value;
	}

	@Override
	public String toString() {
		return String.format("SavingsPerformanceId [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -5698725481983102148L;

}
