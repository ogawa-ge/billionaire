package model.balance;

import java.io.Serializable;

public class Balance implements Serializable{
	private BalanceId balanceId;
	private BalanceMonth balanceMonth;
	private BalanceAmount balanceAmount;

	public Balance(BalanceId balanceId, BalanceMonth balanceMonth, BalanceAmount balanceAmount){
		this.balanceId = balanceId;
		this.balanceMonth = balanceMonth;
		this.balanceAmount = balanceAmount;
	}
	public Balance(){
		balanceId = new BalanceId();
		balanceMonth = new BalanceMonth();
		balanceAmount = new BalanceAmount();
	}

	public BalanceMonth balanceMonth(){
		return balanceMonth;
	}
	public BalanceAmount balanceAmount(){
		return balanceAmount;
	}
	@Deprecated
	public BalanceId getBalanceId(){
		return balanceId;
	}
	@Deprecated
	public BalanceMonth getBalanceMonth(){
		return balanceMonth;
	}
	@Deprecated
	public BalanceAmount getBalanceAmount(){
		return balanceAmount;
	}

	@Override
	public String toString() {
		return String.format("Balance [balanceId=%s, balanceMonth=%s, balanceAmount=%s]", balanceId, balanceMonth,
				balanceAmount);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -2164586220581352178L;

}
