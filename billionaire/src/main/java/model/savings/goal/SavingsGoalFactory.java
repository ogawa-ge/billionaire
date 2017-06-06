package model.savings.goal;

import org.springframework.stereotype.Component;

@Component("savingsGoalFactory")
public class SavingsGoalFactory {
	public SavingsGoal create(){
		return new SavingsGoal();
	}
}
