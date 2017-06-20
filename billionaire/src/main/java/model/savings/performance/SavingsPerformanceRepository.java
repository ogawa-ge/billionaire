package model.savings.performance;

import model.user.UserId;

public interface SavingsPerformanceRepository {
	public SavingsPerformanceList listOf(UserId userId);
	public Integer findTotal(UserId userId);
	public void register(UserId userId, SavingsPerformance savingsPerformance);
}
