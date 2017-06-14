package service.savings.goal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.savings.goal.SavingsGoalRepository;
import model.user.UserId;

@Service("savingsGoalCheckService")
public class SavingsGoalCheckServiceImpl implements SavingsGoalCheckService{
	@Autowired
	private SavingsGoalRepository savingsGoalRepository;

	@Override
	public boolean isNotExists(UserId userId) {
		return savingsGoalRepository.findBy(userId) == null;
	}

	@Override
	public boolean isExists(UserId userId) {
		return !isNotExists(userId);
	}

}
