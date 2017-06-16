package model.fixedcost;

import model.user.UserId;

public interface FixedCostRepository {
	public FixedCostList listOf(UserId userId);
	public void register(FixedCost fixedCost, UserId userId);
	public FixedCost findBy(Integer fixedCostId);
	public void modify(FixedCost fixedCost);
	public void delete(Integer fixedCostId);
	public Integer findTotal(UserId userId);
}
