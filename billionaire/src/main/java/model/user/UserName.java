package model.user;

import java.io.Serializable;

public class UserName implements Serializable{
	private String value;

	public UserName(String value){ this.value = value; }
	public UserName(){ value = ""; }

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
		return String.format("UserName [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -6230142437555802994L;

}
