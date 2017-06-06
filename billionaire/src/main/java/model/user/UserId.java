package model.user;

import java.io.Serializable;

import model.primitiv.Identifiable;

public class UserId implements Serializable, Identifiable{
	private Integer value;

	public UserId(Integer value){ this.value = value; }
	public UserId(){ value = ID_EMPTY; }


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
		return String.format("UserId [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 6499278008537187823L;

}
