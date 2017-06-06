package model.savings.goal;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import model.primitiv.Identifiable;

public class SavingsGoalAmount implements Serializable, Identifiable{
	//TODO 貯金額と収入額の差のアノテーションを作成する
	@NotNull(message="毎月の貯金目標が入力されておりません。")
	@Min(value=0, message="毎月の貯金目標を{value}以上の数字で入力してください。")
	@Max(value=2147483647, message="毎月の貯金目標を{value}以下の数字で入力してください。")
	private Integer value;

	public SavingsGoalAmount(Integer value){
		this.value = value;
	}
	public SavingsGoalAmount(){
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
		return String.format("SavingsGoalAmount [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -8464086792966557276L;

}
