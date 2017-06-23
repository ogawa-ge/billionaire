package model.savings.goal;

import org.springframework.stereotype.Component;

import model.user.UserId;

@Component("savingsGoalFactory")
public class SavingsGoalFactory {
	public SavingsGoal create(UserId userId){
		return new SavingsGoal(userId);
	}
	public SavingsGoal create(){
		return new SavingsGoal();
	}
}
