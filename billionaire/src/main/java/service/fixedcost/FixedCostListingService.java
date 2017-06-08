package service.fixedcost;

import model.fixedcost.FixedCostList;
import model.user.UserId;

public interface FixedCostListingService {
	public FixedCostList listOf(UserId userId);
	public Integer findTotal(UserId userId);
}
