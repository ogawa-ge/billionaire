package service.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.balance.BalanceAmount;
import model.balance.BalanceRepository;
import model.user.UserId;

@Service("balanceDifferenceCalcService")
public class BalanceCalcServiceImpl implements BalanceCalcService{
	@Autowired
	private BalanceRepository balanceRepository;

	@Override
	public BalanceAmount differenceCalc(UserId userId) {
		return balanceRepository.differenceCalc(userId);
	}

}
