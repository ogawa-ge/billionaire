package model.user;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import model.groups.RegisterGroup;

public class UserMail implements Serializable{
	@NotBlank(message="メールアドレスを入力してください。")
	@Email(message="正しいメールアドレスを入力してください。")
	@Length(min=1, max=40, message="メールアドレスを{min}から{max}文字以内で入力してください。")
	@UnUsedMail(groups={RegisterGroup.class})
	private String value;

	public UserMail(String value){ this.value = value; }
	public UserMail(){ value = ""; }

	public String value(){
		return value;
	}

	public boolean isEmpty(){
		return value.isEmpty();
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
		return String.format("UserMail [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 6881929531699700000L;

}
