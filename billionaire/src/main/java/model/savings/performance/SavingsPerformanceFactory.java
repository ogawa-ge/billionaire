package model.savings.performance;

import org.springframework.stereotype.Component;

import model.savings.goal.SavingsGoalAmount;

@Component("savingsPerformanceFactory")
public class SavingsPerformanceFactory {
	public SavingsPerformance create(String date, String amount, String goalAmount){
		return new SavingsPerformance(new SavingsPerformanceId(),
										new SavingsPerformanceRevenueMonth(date),
										new SavingsPerformanceAmount(amount),
										new SavingsGoalAmount(goalAmount));
	}
}
