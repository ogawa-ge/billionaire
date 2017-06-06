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
		incomeMapper.regiser(income, userId);
	}

}
