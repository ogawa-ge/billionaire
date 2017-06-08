package datasource.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.fixedcost.FixedCost;
import model.fixedcost.FixedCostList;
import model.fixedcost.FixedCostRepository;
import model.user.UserId;

@Repository("fixedCostRepository")
public class FixedCostDataAccess implements FixedCostRepository{
	@Autowired
	private FixedCostMapper fixedCostMapper;

	@Override
	public FixedCostList listOf(UserId userId) {
		return new FixedCostList(fixedCostMapper.listOf(userId));
	}

	@Override
	public void registerBy(FixedCost fixedCost, UserId userId) {
		fixedCostMapper.registerBy(fixedCost, userId);
	}

	@Override
	public FixedCost findBy(Integer fixedCostId) {
		return fixedCostMapper.findBy(fixedCostId);
	}

	@Override
	public void modify(FixedCost fixedCost) {
		fixedCostMapper.modify(fixedCost);
	}

	@Override
	public void delete(Integer fixedCostId) {
		fixedCostMapper.delete(fixedCostId);
	}

	@Override
	public Integer findTotal(UserId userId) {
		return fixedCostMapper.findTotal(userId);
	}

}
