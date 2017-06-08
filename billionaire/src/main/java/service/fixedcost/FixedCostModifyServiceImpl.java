package service.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.fixedcost.FixedCost;
import model.fixedcost.FixedCostRepository;

@Service("fixedCostModifyService")
public class FixedCostModifyServiceImpl implements FixedCostModifyService{
	@Autowired
	private FixedCostRepository fixedCostRepository;

	@Override
	public void modify(FixedCost fixedCost) {
		fixedCostRepository.modify(fixedCost);
	}

}
