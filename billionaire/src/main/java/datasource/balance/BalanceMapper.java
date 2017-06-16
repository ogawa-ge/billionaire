package datasource.balance;

import org.apache.ibatis.annotations.Param;

import model.balance.Balance;
import model.balance.BalanceAmount;
import model.balance.BalanceMonth;
import model.user.UserId;

public interface BalanceMapper {
	public BalanceAmount differenceCalc(@Param("userId") UserId userId);
	public void register(@Param("userId") UserId userId, @Param("balanceAmount") BalanceAmount balanceAmount, @Param("balanceMonth") BalanceMonth balanceMonth);
	public Balance findBy(@Param("userId") UserId userId);
	public void modifyAmount(@Param("userId") UserId userId, @Param("balanceAmount") BalanceAmount balanceAmount);
	public void modify(@Param("userId") UserId userId, @Param("balanceAmount") BalanceAmount balanceAmount, @Param("balanceMonth") BalanceMonth balanceMonth);
}
