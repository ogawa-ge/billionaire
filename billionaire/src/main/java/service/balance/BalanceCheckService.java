package service.balance;

import model.user.UserId;

public interface BalanceCheckService {
	public boolean isNotExists(UserId userId);
	public boolean isExists(UserId userId);
	public boolean isNotExceeds(UserId userId, Integer date);
	public boolean isExceeds(UserId userId, Integer date);
}
