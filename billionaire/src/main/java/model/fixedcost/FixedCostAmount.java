package model.fixedcost;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import model.primitiv.Identifiable;

public class FixedCostAmount implements Serializable, Identifiable{
	//TODO 固定費と収入額の差のアノテーションを作成する
	@NotNull(message="固定費を入力してください。")
	@Pattern(regexp = "[0-9]*", message="半角英数字で入力してください。")
	@Range(min=0, max=2147483647, message="正しい固定費を入力してください。")
	private String value;

	public FixedCostAmount(String value){
		this.value = value;
	}
	public FixedCostAmount(){
		value = "";
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
		return String.format("FixedCostAmount [value=%s]", value);
	}


	/**
	 *
	 */
	private static final long serialVersionUID = 8604455656557306962L;

}
