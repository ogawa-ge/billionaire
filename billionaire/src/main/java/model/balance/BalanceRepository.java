package model.balance;

import model.user.UserId;

public interface BalanceRepository {
	public BalanceAmount differenceCalc(UserId userId);
	public void register(UserId userId, BalanceAmount balanceAmount, BalanceMonth balanceMonth);
	public Balance findBy(UserId userId);
	public void modifyAmount(UserId userId, BalanceAmount balanceAmount);
	public void modify(UserId userId, BalanceAmount balanceAmount, BalanceMonth balanceMonth);
}
