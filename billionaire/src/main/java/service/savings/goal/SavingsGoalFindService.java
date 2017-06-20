package service.savings.goal;

import model.savings.goal.SavingsGoal;
import model.user.UserId;

public interface SavingsGoalFindService {
	public SavingsGoal findBy(UserId userId);
}
