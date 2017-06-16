package service.savings.performance;

import model.savings.performance.SavingsPerformanceList;
import model.user.UserId;

public interface SavingsPerformanceListingService {
	public SavingsPerformanceList listOf(UserId userId);
	public Integer findTotal(UserId userId);
}
