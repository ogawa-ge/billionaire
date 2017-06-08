package web.fixedcost;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.fixedcost.FixedCost;
import model.fixedcost.FixedCostFactory;
import model.user.User;
import service.fixedcost.FixedCostFindService;
import service.fixedcost.FixedCostModifyService;

@Controller("fixedCostModifyController")
@RequestMapping("modify/fixed_cost")
@SessionAttributes("user")
public class FixedCostModifyController {
	@Autowired
	private FixedCostFactory fixedCostFactory;
	@Autowired
	private FixedCostFindService fixedCostFindService;
	@Autowired
	private FixedCostModifyService fixedCostModifyService;

	@RequestMapping(method=RequestMethod.POST, params="fixedCostId")
	public String modyfy(Model model, @RequestParam("fixedCostId") Integer fixedCostId, @ModelAttribute("user") User user){
		model.addAttribute("fixedCost", fixedCostFindService.findBy(fixedCostId));
		return "setting/fixed_cost_modify";
	}

	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute(Model model, @Valid @ModelAttribute("fixedCost") FixedCost fixedCost, Errors errors, User user, RedirectAttributes redirectAttributes){

		if(errors.hasErrors()){
			model.addAttribute("fixedCost", fixedCostFindService.findBy(fixedCost.fixedCostId().value()));
			return "setting/fixed_cost_modify";
		}

		fixedCostModifyService.modify(fixedCost);
		redirectAttributes.addFlashAttribute("user", user);

		return "redirect:../../register/fixed_cost/list";
	}
}
