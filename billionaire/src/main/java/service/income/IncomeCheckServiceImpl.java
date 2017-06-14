package service.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.balance.BalanceRepository;
import model.income.IncomeRepository;
import model.user.UserId;

@Service("incomeCheckService")
public class IncomeCheckServiceImpl implements IncomeCheckService{
	@Autowired
	private IncomeRepository incomeRepository;
	@Autowired
	private BalanceRepository balanceRepository;

	@Override
	public boolean isNotExists(UserId userId) {
		return incomeRepository.findBy(userId) == null;
	}

	@Override
	public boolean isExists(UserId userId) {
		return !isNotExists(userId);
	}

	@Override
	public boolean isNotExceeds(UserId userId, Integer month, Integer date) {/*超えていない*/
		Integer balanceMonth = Integer.parseInt(balanceRepository.findBy(userId).balanceMonth().value());

		if(balanceMonth > month) return true;
		else if(balanceMonth < month) return false;

		return Integer.parseInt(incomeRepository.findBy(userId).incomeRevenueDate().value()) > date;
	}

	@Override
	public boolean isExceeds(UserId userId, Integer month, Integer date) {/*超えている*/
		return !isNotExceeds(userId, month, date);
	}

}
