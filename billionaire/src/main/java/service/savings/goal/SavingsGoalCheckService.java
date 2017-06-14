package service.savings.goal;

import model.user.UserId;

public interface SavingsGoalCheckService {
	public boolean isNotExists(UserId userId);
	public boolean isExists(UserId userId);

}
