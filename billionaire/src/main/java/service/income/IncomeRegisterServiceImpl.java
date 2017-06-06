package service.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.income.Income;
import model.income.IncomeRepository;
import model.user.UserId;

@Service("incomeRegisterService")
public class IncomeRegisterServiceImpl implements IncomeRegisterService{
	@Autowired
	private IncomeRepository incomeRepository;

	@Override
	public void registerBy(Income income, UserId userId) {
		incomeRepository.registerBy(income, userId);
	}

}
