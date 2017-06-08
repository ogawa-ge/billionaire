package model.fixedcost;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class FixedCostName implements Serializable{
	@NotBlank(message="固定費名を入力して下さい。")
	@Length(min=0,max=50, message="固定費名を{min}から{max}文字の間で入力してください。")
	private String value;

	public FixedCostName(String value){
		this.value = value;
	}
	public FixedCostName(){
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
		return String.format("FixedCostName [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -5330710978350680889L;

}
