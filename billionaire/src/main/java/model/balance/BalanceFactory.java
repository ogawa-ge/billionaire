package model.balance;

import org.springframework.stereotype.Component;

@Component("balanceFactory")
public class BalanceFactory {
	public Balance create(){
		return new Balance();
	}
}
