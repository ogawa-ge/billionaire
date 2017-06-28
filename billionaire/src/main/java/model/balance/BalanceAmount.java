package model.balance;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class BalanceAmount implements Serializable{
	@NotNull(message="今月の残り使用可能金額を入力してください。")
	@Pattern(regexp = "[0-9]*", message="半角英数字で入力してください。")
	@Range(min=0, max=2147483647, message="正しい今月の残り使用可能金額を入力してください。")
	private String value;

	public BalanceAmount(String value){
		this.value = value;
	}
	public BalanceAmount(){
		value = "";
	}

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
		return String.format("BalanceAmount [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = -3028857810784529074L;

}
