package service.savings.performance;

import model.savings.performance.SavingsPerformance;
import model.user.UserId;

public interface SavingsPerformanceRegisterService {
	public void register(UserId userId, SavingsPerformance create);
}
