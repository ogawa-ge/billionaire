package service.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.fixedcost.FixedCost;
import model.fixedcost.FixedCostRepository;
import model.user.UserId;

@Service("fixedCostRegisterService")
public class FixedCostRegisterServiceImpl implements FixedCostRegisterService{
	@Autowired
	private FixedCostRepository fixedCostRepository;

	@Override
	public void registerBy(FixedCost fixedCost, UserId userId) {
		fixedCostRepository.registerBy(fixedCost, userId);
	}

}
