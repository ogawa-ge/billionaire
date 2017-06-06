package model.income;

import model.user.UserId;

public interface IncomeRepository {
	public void register(Income income, UserId userId);
}
