package web.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import service.fixedcost.FixedCostDeleateService;

@Controller("fixedCostDeleateController")
@RequestMapping("delete/fixed_cost")
@SessionAttributes("user")
public class FixedCostDeleateController {
	@Autowired
	private FixedCostDeleateService fixedCostDeleateService;

	@RequestMapping(method=RequestMethod.POST, params="fixedCostId")
	public String delete(@RequestParam("fixedCostId") Integer fixedCostId){
		fixedCostDeleateService.delete(fixedCostId);
		return "redirect:../register/fixed_cost/list";
	}
}
