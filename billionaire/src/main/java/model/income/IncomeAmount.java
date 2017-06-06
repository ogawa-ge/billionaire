package model.income;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import model.primitiv.Identifiable;

public class IncomeAmount implements Serializable, Identifiable{
	@NotNull(message="収入金額を入力してください。")
	@Min(value=0, message="収入金額を{value}以上の数字で入力してください。")
	@Max(value=2147483647, message="収入金額を{value}以下の数字で入力してください。")
	private Integer value;

	public IncomeAmount(Integer value){ this.value = value; }
	public IncomeAmount(){ value = ID_EMPTY; }

	@Deprecated
	public void setValue(Integer value){
		this.value = value;
	}
	@Deprecated
	public Integer getValue(){
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
