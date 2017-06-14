package service.fixedcost;

import model.fixedcost.FixedCost;
import model.user.UserId;

public interface FixedCostRegisterService {
	public void register(FixedCost fixedCost, UserId userId);
}
