package service.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.balance.BalanceAmount;
import model.balance.BalanceMonth;
import model.balance.BalanceRepository;
import model.user.UserId;

@Service("balanceModifyService")
public class BalanceModifyServiceImpl implements BalanceModifyService{
	@Autowired
	private BalanceRepository balanceRepository;

	@Override
	public void modify(UserId userId, BalanceAmount balanceAmount, BalanceMonth balanceMonth) {
		balanceRepository.modify(userId, balanceAmount, balanceMonth);
	}

}
