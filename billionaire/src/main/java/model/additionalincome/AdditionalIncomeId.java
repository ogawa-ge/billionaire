package model.additionalincome;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class AdditionalIncomeId implements Serializable, Identifiable{
	private Integer value;

	public AdditionalIncomeId(Integer value){
		this.value = value;
	}
	public AdditionalIncomeId(){
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
		return String.format("AdditionalIncomeId [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -2685754235873861908L;

}
