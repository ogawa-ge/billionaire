package service.savings.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.savings.goal.SavingsGoal;
import model.savings.goal.SavingsGoalRepository;
import model.user.UserId;

@Service("savingsGoalRegisterService")
public class SavingsGoalRegisterServiceImpl implements SavingsGoalRegisterService{
	@Autowired
	SavingsGoalRepository savingsGoalRepository;

	@Override
	public void register(SavingsGoal savingsGoal, UserId userId) {
		savingsGoalRepository.register(savingsGoal, userId);
	}

}
