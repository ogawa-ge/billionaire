package service.income;

import model.user.UserId;

public interface IncomeCheckService {
	public boolean isNotExists(UserId userId);
	public boolean isExists(UserId userId);
	public boolean isNotExceeds(UserId userId, Integer month, Integer date);
	public boolean isExceeds(UserId userId, Integer month, Integer date);
}
