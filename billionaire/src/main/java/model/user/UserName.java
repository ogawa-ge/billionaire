package model.user;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class UserName implements Serializable{
	@NotBlank(message="名前を入力してください。")
	@Length(min=1, max=50, message="名前を{min}から{max}文字以内で入力してください。")
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
