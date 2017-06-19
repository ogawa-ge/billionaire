package web.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.user.User;
import service.fixedcost.FixedCostListingService;

@Controller("fixedCostListContoroller")
@SessionAttributes("user")
@RequestMapping("register/fixed_cost/list")
public class FixedCostListingContoroller {
	@Autowired
	private FixedCostListingService fixedCostListingService;

	@RequestMapping
	public String listing(Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../../login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		model.addAttribute("fixedCostList", fixedCostListingService.listOf(user.userId()));
		model.addAttribute("fixedCostTotal", fixedCostListingService.findTotal(user.userId()));
		return "fixed_cost/fixed_cost_list";
	}

	@RequestMapping(value="next", method=RequestMethod.POST)
	public String next(Model model, User user){
		return "redirect:../../savings_goal";
	}

}
