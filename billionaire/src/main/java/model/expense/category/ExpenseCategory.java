package model.expense.category;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ExpenseCategory {
	FOOD_EXPENSES("食費"),
	UTILITY_COST("水道・光熱費"),
	CLOTHING_COST("被服費"),
	EDUCATIONAL_EXPENSES("教育費"),
	CULTURAL_EXPENSES("教養・娯楽費"),
	COMMUNICATION_FEE("通信費"),
	MEDICAL_BILLS("医療・衛生費"),
	ENTERTAINMENT_EXPENSES("交際費"),
	VEHICLE_COST("車両費"),
	SPECIAL_COST("特別費"),
	OTHER("その他");

	private String label;

	private ExpenseCategory(String label){
		this.label = label;
	}

	private String label(){
		return label;
	}

	public Map<String, String> options(){
		Map<String, String> options = new LinkedHashMap<String, String>();
		for( ExpenseCategory expenseCategory : ExpenseCategory.values() ){
			options.put(expenseCategory.name(), expenseCategory.label());
		}
		return options;
	}

	@Deprecated
	public String getlabel(){
		return label;
	}

}
