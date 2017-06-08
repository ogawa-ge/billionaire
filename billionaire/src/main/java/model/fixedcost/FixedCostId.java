package model.fixedcost;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class FixedCostId implements Serializable, Identifiable{
	private Integer value;

	public FixedCostId(Integer value){
		this.value = value;
	}
	public FixedCostId(){
		value = ID_EMPTY;
	}


	public Integer value(){
		return value;
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
		return String.format("FixedCostId [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -3088631283456835053L;

}
