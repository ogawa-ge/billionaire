package model.expense;

import java.io.Serializable;

public class ExpenseMemo implements Serializable{
	private String value;

	public ExpenseMemo(String value){
		this.value = value;
	}
	public ExpenseMemo(){
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
		return String.format("ExpenseMemo [value=%s]", value);
	}
	/**
	 *
	 */
	private static final long serialVersionUID = -1096675375810623368L;

}
