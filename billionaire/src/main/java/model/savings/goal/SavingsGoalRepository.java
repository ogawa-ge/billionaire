package model.savings.goal;

import model.user.UserId;

public interface SavingsGoalRepository {
	public void register(SavingsGoal savingsGoal, UserId userId);
	public SavingsGoal findBy(UserId userId);
}
