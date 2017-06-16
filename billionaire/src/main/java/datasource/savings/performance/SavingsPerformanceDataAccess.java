package datasource.savings.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.savings.performance.SavingsPerformanceList;
import model.savings.performance.SavingsPerformanceRepository;
import model.user.UserId;

@Repository("savingsPerformanceRepository")
public class SavingsPerformanceDataAccess implements SavingsPerformanceRepository{
	@Autowired
	private SavingsPerformanceMapper savingsPerformanceMapper;

	@Override
	public SavingsPerformanceList listOf(UserId userId) {
		return new SavingsPerformanceList(savingsPerformanceMapper.listOf(userId));
	}

	@Override
	public Integer findTotal(UserId userId) {
		return savingsPerformanceMapper.findTotal(userId);
	}

}
