package model.fixedcost;

import org.springframework.stereotype.Component;

@Component("fixedCostFactory")
public class FixedCostFactory {
	public FixedCost create(){
		return new FixedCost();
	}
}
