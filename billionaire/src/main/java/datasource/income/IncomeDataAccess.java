package datasource.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.income.Income;
import model.income.IncomeRepository;
import model.user.UserId;

@Repository("incomeRepository")
public class IncomeDataAccess implements IncomeRepository{
	@Autowired
	private IncomeMapper incomeMapper;

	@Override
	public void register(Income income, UserId userId) {
		incomeMapper.register(income, userId);
	}

	@Override
	public Income findBy(UserId userId) {
		return incomeMapper.findBy(userId);
	}

	@Override
	public Integer findAmount(UserId userId) {
		return incomeMapper.findAmount(userId);
	}

	@Override
	public void modify(UserId userId, Income income) {
		incomeMapper.modify(userId, income);
	}

}
