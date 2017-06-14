package service.balance;

import model.balance.BalanceAmount;
import model.balance.BalanceMonth;
import model.user.UserId;

public interface BalanceModifyService {
	public void modify(UserId userId, BalanceAmount balanceAmount, BalanceMonth balanceMonth);
}
