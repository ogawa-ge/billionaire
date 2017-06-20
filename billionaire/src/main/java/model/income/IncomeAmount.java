package model.income;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

public class IncomeAmount implements Serializable{
	@NotNull(message="収入金額を入力してください。")
	@Pattern(regexp = "[0-9]*", message="半角英数字で入力してください。")
	@Range(min=0, max=2147483647, message="正しい収入金額を入力してください。")
	private String value;

	public IncomeAmount(String value){ this.value = value; }
	public IncomeAmount(){ value = ""; }

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
		return String.format("IncomeAmount [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 2667565565656844086L;

}
