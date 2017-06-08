package service.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.fixedcost.FixedCostRepository;

@Service("fixedCostDeleateService")
public class FixedCostDeleateServiceImpl implements FixedCostDeleateService{
	@Autowired
	private FixedCostRepository fixedcostRepository;

	@Override
	public void delete(Integer fixedCostId) {
		fixedcostRepository.delete(fixedCostId);
	}

}
