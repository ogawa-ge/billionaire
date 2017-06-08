package service.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.fixedcost.FixedCost;
import model.fixedcost.FixedCostRepository;

@Service("fixedCostFindService")
public class FixedCostFindServiceImpl implements FixedCostFindService{
	@Autowired
	private FixedCostRepository fixedCostRepository;

	@Override
	public FixedCost findBy(Integer fixedCostId) {
		return fixedCostRepository.findBy(fixedCostId);
	}

}
