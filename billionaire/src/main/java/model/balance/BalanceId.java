package model.balance;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class BalanceId implements Serializable, Identifiable{
	private Integer value;

	public BalanceId(Integer value){
		this.value = value;
	}
	public BalanceId(){
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
		return String.format("BalanceId [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -7346811677282218114L;

}
