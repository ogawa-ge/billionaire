package service.income;

import model.income.Income;
import model.user.UserId;

public interface IncomeFindService {
	public Income findBy(UserId userId);
}
