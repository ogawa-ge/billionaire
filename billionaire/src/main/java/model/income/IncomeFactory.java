package model.income;

import org.springframework.stereotype.Component;

@Component("incomeFactory")
public class IncomeFactory {
	public Income create(){
		return new Income();
	}
}
