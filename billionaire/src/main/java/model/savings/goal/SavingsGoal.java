package model.savings.goal;

import java.io.Serializable;

import javax.validation.Valid;

import model.user.UserId;

public class SavingsGoal implements Serializable{
	private UserId userId;
	@Valid
	private SavingsGoalAmount savingsGoalAmount;
	private SavingsGoalId savingsGoalId;

	public SavingsGoal(UserId userId, SavingsGoalAmount savingsGoalAmount, SavingsGoalId savingsGoalId){
		this.userId = userId;
		this.savingsGoalAmount = savingsGoalAmount;
		this.savingsGoalId = savingsGoalId;
	}
	public SavingsGoal(UserId userId) {
		this.userId = userId;
		savingsGoalAmount = new SavingsGoalAmount();
		savingsGoalId = new SavingsGoalId();
	}
	public SavingsGoal(){
		userId = new UserId();
		savingsGoalAmount = new SavingsGoalAmount();
		savingsGoalId = new SavingsGoalId();
	}


	@OverAvailableAmount(message="貯金目標金額が、「収入＋固定費合計金額」を上回っています。")
	public SavingsGoal getSavingsGoal() {
		return this;
	}
	public boolean isEmpty(){
		return savingsGoalAmount.isEmpty();
	}


	public SavingsGoalAmount savingsGoalAmount(){
		return savingsGoalAmount;
	}
	public UserId userId(){
		return userId;
	}
	@Deprecated
	public UserId getUserId(){
		return userId;
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
		return String.format("SavingsGoal [userId=%s, savingsGoalAmount=%s, savingsGoalId=%s]", userId,
				savingsGoalAmount, savingsGoalId);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -859392983877498723L;

}
