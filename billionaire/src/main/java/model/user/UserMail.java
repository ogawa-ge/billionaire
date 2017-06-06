package model.user;

import java.io.Serializable;

public class UserMail implements Serializable{
	private String value;

	public UserMail(String value){ this.value = value; }
	public UserMail(){ value = ""; }

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
		return String.format("UserMail [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 6881929531699700000L;

}
