package service.savings.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.savings.performance.SavingsPerformance;
import model.savings.performance.SavingsPerformanceRepository;
import model.user.UserId;

@Service("savingsPerformanceRegisterService")
public class SavingsPerformanceRegisterServiceImpl implements SavingsPerformanceRegisterService{
	@Autowired
	private SavingsPerformanceRepository savingsPsrformanceRepository;

	@Override
	public void register(UserId userId, SavingsPerformance savingsPerformance) {
		savingsPsrformanceRepository.register(userId, savingsPerformance);
	}

}
