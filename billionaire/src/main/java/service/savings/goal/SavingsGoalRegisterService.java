package service.savings.goal;

import model.savings.goal.SavingsGoal;
import model.user.UserId;

public interface SavingsGoalRegisterService {
	public void registerBy(SavingsGoal savingsGoal, UserId userId);
}
