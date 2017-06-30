package service.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.income.Income;
import model.income.IncomeRepository;
import model.user.UserId;

@Service("incomeModifyService")
public class IncomeModifyServiceImpl implements IncomeModifyService{
	@Autowired
	private IncomeRepository incomeRepository;

	@Override
	public void modify(UserId userId, Income income) {
		incomeRepository.modify(userId, income);
	}
}
