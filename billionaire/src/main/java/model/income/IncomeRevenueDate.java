package model.income;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class IncomeRevenueDate implements Serializable{
	@NotBlank(message="毎月の所得日を入力してください。")
	@Pattern(regexp="0?[1-9]|[1-2][0-9]|3[0-1]", message="毎月の所得日を半角英数字で1～31の間で入力してください。")
	private String value;

	public IncomeRevenueDate(String value){ this.value = value; }
	public IncomeRevenueDate(){ value = ""; }

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
		return String.format("IncomeRevenueDate [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = 8156792380587489846L;

}
