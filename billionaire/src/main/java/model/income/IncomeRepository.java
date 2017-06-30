package model.income;

import model.user.UserId;

public interface IncomeRepository {
	public void register(Income income, UserId userId);
	public Income findBy(UserId userId);
	public Integer findAmount(UserId userId);
	public void modify(UserId userId, Income income);
}
