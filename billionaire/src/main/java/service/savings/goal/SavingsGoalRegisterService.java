package service.savings.goal;

import model.savings.goal.SavingsGoal;
import model.user.UserId;

public interface SavingsGoalRegisterService {
	public void register(SavingsGoal savingsGoal, UserId userId);
}
