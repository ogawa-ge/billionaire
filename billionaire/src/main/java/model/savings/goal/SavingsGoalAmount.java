package model.savings.goal;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import model.primitiv.Identifiable;

public class SavingsGoalAmount implements Serializable, Identifiable{
	//TODO 貯金額と収入額の差のアノテーションを作成する
	@NotNull(message="毎月の貯金目標が入力されておりません。")
	@Pattern(regexp = "[0-9]*", message="半角英数字で入力してください。")
	@Range(min=0, max=2147483647, message="正しい貯金目標を入力してください。")
	private String value;

	public SavingsGoalAmount(String value){
		this.value = value;
	}
	public SavingsGoalAmount(){
		value = "";
	}

	public String value(){
		return value;
	}
	public boolean isEmpty() {
		return value.isEmpty();
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
		return String.format("SavingsGoalAmount [value=%s]", value);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -8464086792966557276L;

}
