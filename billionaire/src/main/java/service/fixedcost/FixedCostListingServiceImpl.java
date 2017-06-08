package service.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.fixedcost.FixedCostList;
import model.fixedcost.FixedCostRepository;
import model.user.UserId;

@Service("fixedCostListingService")
public class FixedCostListingServiceImpl implements FixedCostListingService{
	@Autowired
	private FixedCostRepository fixedCostRepository;

	@Override
	public FixedCostList listOf(UserId userId) {
		return fixedCostRepository.listOf(userId);
	}

	@Override
	public Integer findTotal(UserId userId) {
		return fixedCostRepository.findTotal(userId);
	}

}
