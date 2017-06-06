package model.user;

import java.io.Serializable;

public class UserPassword implements Serializable{
	private String value;

	public UserPassword(String value){ this.value = value; }
	public UserPassword(){ value = ""; }

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
		return String.format("UserPassword [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -6243362786280049356L;

}
