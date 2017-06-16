package model.user;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class UserPassword implements Serializable{
	@NotBlank(message="パスワードを入力してください。")
	@Length(min=4, max=15, message="パスワードを{min}文字以上、{max}文字以内で入力してください。")
	private String value;

	public UserPassword(String value){ this.value = value; }
	public UserPassword(){ value = ""; }

	public String value(){
		return value;
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
		return String.format("UserPassword [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -6243362786280049356L;

}
