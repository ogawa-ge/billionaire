package service.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.balance.Balance;
import model.balance.BalanceRepository;
import model.user.UserId;

@Service("balanceFindService")
public class BalanceFindServiceImpl implements BalanceFindService{
	@Autowired
	private BalanceRepository balanceRepository;

	@Override
	public Balance findBy(UserId userId) {
		return balanceRepository.findBy(userId);
	}

}
