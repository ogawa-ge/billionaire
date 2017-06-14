package service.balance;

import model.balance.Balance;
import model.user.UserId;

public interface BalanceFindService {
	public Balance findBy(UserId userId);
}
