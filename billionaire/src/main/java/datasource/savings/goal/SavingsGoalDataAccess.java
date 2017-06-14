package datasource.savings.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.savings.goal.SavingsGoal;
import model.savings.goal.SavingsGoalRepository;
import model.user.UserId;

@Repository("savingsGoalRepository")
public class SavingsGoalDataAccess implements SavingsGoalRepository{
	@Autowired
	SavingsGoalMapper savingsGoalMapper;

	@Override
	public void register(SavingsGoal savingsGoal, UserId userId) {
		savingsGoalMapper.register(savingsGoal, userId);
	}

	@Override
	public SavingsGoal findBy(UserId userId) {
		return savingsGoalMapper.findBy(userId);
	}


}
