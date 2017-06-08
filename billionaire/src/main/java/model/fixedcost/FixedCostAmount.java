package model.fixedcost;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import model.primitiv.Identifiable;

public class FixedCostAmount implements Serializable, Identifiable{
	//TODO 固定費と収入額の差のアノテーションを作成する
	@NotNull(message="固定費を入力してください。")
	@Min(value=1, message="固定費を{value}以上の数字で入力してください。")
	@Max(value=2147483647, message="固定費を{value}以下の数字で入力してください。")
	private Integer value;

	public FixedCostAmount(Integer value){
		this.value = value;
	}
	public FixedCostAmount(){
		value = ID_EMPTY;
	}

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
		return String.format("FixedCostAmount [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = 8604455656557306962L;

}
