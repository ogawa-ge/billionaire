package model.income;

import model.user.UserId;

public interface IncomeRepository {
	public void registerBy(Income income, UserId userId);
}
