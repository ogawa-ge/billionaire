package service.balance;

import model.balance.BalanceAmount;
import model.balance.BalanceMonth;
import model.user.UserId;

public interface BalanceRegisterService {
	public void register(UserId userId, BalanceAmount balanceAmount, BalanceMonth balanceMonth);
}
