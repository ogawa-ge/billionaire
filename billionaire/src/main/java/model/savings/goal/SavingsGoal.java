package model.savings.goal;

import java.io.Serializable;

import javax.validation.Valid;

public class SavingsGoal implements Serializable{
	@Valid
	private SavingsGoalAmount savingsGoalAmount;
	private SavingsGoalId savingsGoalId;

	public SavingsGoal(SavingsGoalAmount savingsGoalAmount, SavingsGoalId savingsGoalId){
		this.savingsGoalAmount = savingsGoalAmount;
		this.savingsGoalId = savingsGoalId;
	}
	public SavingsGoal(){
		savingsGoalAmount = new SavingsGoalAmount();
		savingsGoalId = new SavingsGoalId();
	}

	public SavingsGoalAmount savingsGoalAmount(){
		return savingsGoalAmount;
	}
	@Deprecated
	public SavingsGoalAmount getSavingsGoalAmount(){
		return savingsGoalAmount;
	}
	@Deprecated
	public SavingsGoalId getSavingsGoalId(){
		return savingsGoalId;
	}

	@Override
	public String toString() {
		return String.format("SavingsGoal [savingsGoalAmount=%s, savingsGoalId=%s]", savingsGoalAmount, savingsGoalId);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -859392983877498723L;

}
