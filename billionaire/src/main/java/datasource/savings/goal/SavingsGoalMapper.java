package datasource.savings.goal;

import org.apache.ibatis.annotations.Param;

import model.savings.goal.SavingsGoal;
import model.user.UserId;

public interface SavingsGoalMapper {
	public void register(@Param("savingsGoal") SavingsGoal savingsGoal, @Param("userId") UserId userId);
	public SavingsGoal findBy(@Param("userId") UserId userId);
}
