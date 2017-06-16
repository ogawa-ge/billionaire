package service.savings.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.savings.performance.SavingsPerformanceList;
import model.savings.performance.SavingsPerformanceRepository;
import model.user.UserId;

@Service("savingsPerformanceListingService")
public class SavingsPerformanceListingServiceImpl implements SavingsPerformanceListingService{
	@Autowired
	private SavingsPerformanceRepository savingsPerformanceRepository;

	@Override
	public SavingsPerformanceList listOf(UserId userId) {
		return savingsPerformanceRepository.listOf(userId);
	}

	@Override
	public Integer findTotal(UserId userId) {
		return savingsPerformanceRepository.findTotal(userId);
	}

}
