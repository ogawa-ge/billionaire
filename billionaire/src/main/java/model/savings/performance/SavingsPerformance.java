package model.savings.performance;

import java.io.Serializable;

import model.savings.goal.SavingsGoalAmount;

public class SavingsPerformance implements Serializable{
	private SavingsPerformanceId savingsPerformanceId;
	private SavingsPerformanceRevenueMonth savingsPerformanceRevenueMonth;
	private SavingsPerformanceAmount savingsPerformanceAmount;
	private SavingsGoalAmount savingsGoalAmount;

	public SavingsPerformance(SavingsPerformanceId savingsPerformanceId, SavingsPerformanceRevenueMonth savingsPerformanceRevenueMonth, SavingsPerformanceAmount savingsPerformanceAmount, SavingsGoalAmount savingsGoalAmount){
		this.savingsPerformanceId = savingsPerformanceId;
		this.savingsPerformanceRevenueMonth = savingsPerformanceRevenueMonth;
		this.savingsPerformanceAmount = savingsPerformanceAmount;
		this.savingsGoalAmount = savingsGoalAmount;
	}
	public SavingsPerformance(){
		savingsPerformanceId = new SavingsPerformanceId();
		savingsPerformanceRevenueMonth = new SavingsPerformanceRevenueMonth();
		savingsPerformanceAmount = new SavingsPerformanceAmount();
		savingsGoalAmount = new SavingsGoalAmount();
	}

	@Deprecated
	public SavingsPerformanceId getSavingsPerformanceId(){
		return savingsPerformanceId;
	}
	@Deprecated
	public SavingsPerformanceRevenueMonth getSavingsPerformanceRevenueMonth(){
		return savingsPerformanceRevenueMonth;
	}
	@Deprecated
	public SavingsPerformanceAmount getSavingsPerformanceAmount(){
		return savingsPerformanceAmount;
	}
	@Deprecated
	public SavingsGoalAmount getSavingsGoalAmount(){
		return savingsGoalAmount;
	}

	@Override
	public String toString() {
		return String.format(
				"SavingsPerformance [savingsPerformanceId=%s, savingsPerformanceRevenueMonth=%s, savingsPerformanceAmount=%s, savingsGoalAmount=%s]",
				savingsPerformanceId, savingsPerformanceRevenueMonth, savingsPerformanceAmount, savingsGoalAmount);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -643197085793295L;

}
