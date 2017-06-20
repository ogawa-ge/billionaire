package service.savings.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.savings.goal.SavingsGoal;
import model.savings.goal.SavingsGoalRepository;
import model.user.UserId;

@Service("savingsGoalFindService")
public class SavingsGoalFindServiceImpl implements SavingsGoalFindService{
	@Autowired
	private SavingsGoalRepository savingsGoalRepository;

	@Override
	public SavingsGoal findBy(UserId userId) {
		return savingsGoalRepository.findBy(userId);
	}

}
