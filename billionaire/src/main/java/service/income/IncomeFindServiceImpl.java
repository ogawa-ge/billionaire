package service.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.income.Income;
import model.income.IncomeRepository;
import model.user.UserId;

@Service("incomeFindService")
public class IncomeFindServiceImpl implements IncomeFindService{
	@Autowired
	private IncomeRepository incomeRepository;

	@Override
	public Income findBy(UserId userId) {
		return incomeRepository.findBy(userId);
	}

}
