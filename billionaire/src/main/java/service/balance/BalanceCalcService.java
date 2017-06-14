package service.balance;

import model.balance.BalanceAmount;
import model.user.UserId;

public interface BalanceCalcService {
	public BalanceAmount differenceCalc(UserId userId);
}
