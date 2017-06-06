package service.income;

import model.income.Income;
import model.user.UserId;

public interface IncomeRegisterService {
	public void registerBy(Income income, UserId userId);
}
