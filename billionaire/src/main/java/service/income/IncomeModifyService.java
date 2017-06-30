package service.income;

import model.income.Income;
import model.user.UserId;

public interface IncomeModifyService {
	public void modify(UserId userId, Income income);
}
