package datasource.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.balance.Balance;
import model.balance.BalanceAmount;
import model.balance.BalanceMonth;
import model.balance.BalanceRepository;
import model.user.UserId;

@Repository("balanceRepository")
public class BalanceDataAccess implements BalanceRepository{
	@Autowired
	private BalanceMapper balanceMapper;

	@Override
	public BalanceAmount differenceCalc(UserId userId) {
		return balanceMapper.differenceCalc(userId);
	}

	@Override
	public void register(UserId userId, BalanceAmount balanceAmount, BalanceMonth balanceMonth) {
		balanceMapper.register(userId, balanceAmount, balanceMonth);
	}

	@Override
	public Balance findBy(UserId userId) {
		return balanceMapper.findBy(userId);
	}

	@Override
	public void modifyAmount(UserId userId, BalanceAmount balanceAmount) {
		balanceMapper.modifyAmount(userId, balanceAmount);
	}

	@Override
	public void modify(UserId userId, BalanceAmount balanceAmount, BalanceMonth balanceMonth) {
		balanceMapper.modify(userId, balanceAmount, balanceMonth);
	}

}
