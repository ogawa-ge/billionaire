package service.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.balance.BalanceAmount;
import model.balance.BalanceMonth;
import model.balance.BalanceRepository;
import model.user.UserId;

@Service("balanceregisterService")
public class BalanceRegisterServiceImpl implements BalanceRegisterService{
	@Autowired
	private BalanceRepository balanceRepository;

	@Override
	public void register(UserId userId, BalanceAmount balanceAmount, BalanceMonth balanceMonth) {
		balanceRepository.register(userId, balanceAmount, balanceMonth);
	}

}
