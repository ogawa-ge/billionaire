package datasource.savings.performance;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.savings.performance.SavingsPerformance;
import model.user.UserId;

public interface SavingsPerformanceMapper {
	public List<SavingsPerformance> listOf(@Param("userId") UserId userId);
	public Integer findTotal(@Param("userId") UserId userId);
}
