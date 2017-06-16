package model.expense;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class ExpenseAmount implements Serializable{
	@NotBlank(message="出費額を入力してください。")
	@Range(min=0, max=2147483647, message="正しい収入金額を入力してください。")
	private String value;

	public ExpenseAmount(String value){
		this.value = value;
	}
	public ExpenseAmount(){
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
		return String.format("ExpenseAmount [value=%s]", value);
	}
	/**
	 *
	 */
	private static final long serialVersionUID = -3442952123825562461L;

}
