package service.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.balance.BalanceRepository;
import model.income.IncomeRepository;
import model.user.UserId;

@Service("balanceCheckService")
public class BalanceCheckServiceImpl implements BalanceCheckService{
	@Autowired
	private BalanceRepository balanceRepository;
	@Autowired
	private IncomeRepository incomeRepository;

	@Override
	public boolean isNotExists(UserId userId) {
		return balanceRepository.findBy(userId) == null;
	}
	@Override
	public boolean isExists(UserId userId) {
		return !isExists(userId);
	}
	@Override
	public boolean isNotExceeds(UserId userId, Integer date) {/*超えていない*/
		return Integer.valueOf(incomeRepository.findBy(userId).incomeRevenueDate().value()) > date;
	}

	@Override
	public boolean isExceeds(UserId userId, Integer date) {/*超えている*/
		return !isNotExceeds(userId, date);
	}
}
