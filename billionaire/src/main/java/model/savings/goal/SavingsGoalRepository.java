package model.savings.goal;

import model.user.UserId;

public interface SavingsGoalRepository {
	public void registerBy(SavingsGoal savingsGoal, UserId userId);
}
