package model.income;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import model.primitiv.Identifiable;

public class IncomeRevenueDate implements Serializable, Identifiable{
	@NotNull(message="毎月の所得日を入力してください。")
	@Min(value=1, message="毎月の所得日は{value}以上の数字で入力してください。")
	@Max(value=31, message="毎月の所得日は{value}以下の数字で入力してください。")
	private Integer value;

	public IncomeRevenueDate(Integer value){ this.value = value; }
	public IncomeRevenueDate(){ value = ID_EMPTY; }

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
		return String.format("IncomeRevenueDate [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = 8156792380587489846L;

}
