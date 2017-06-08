package web.fixedcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.user.User;
import service.fixedcost.FixedCostListingService;

@Controller("fixedCostListContoroller")
@SessionAttributes("user")
@RequestMapping("register/fixed_cost/list")
public class FixedCostListContoroller {
	@Autowired
	private FixedCostListingService fixedCostListingService;

	@RequestMapping
	public String listing(Model model, @ModelAttribute("user") User user){
/*テスト用
user.userId().setValue(1);*/
		model.addAttribute("fixedCostList", fixedCostListingService.listOf(user.userId()));
		model.addAttribute("fixedCostTotal", fixedCostListingService.findTotal(user.userId()));
		return "setting/fixed_cost_list";
	}
	@RequestMapping(value="new_fixed_cost", method=RequestMethod.POST)
	public String register(Model model, User user, RedirectAttributes redirectAttributes){
		model.addAttribute("fixedCostList", fixedCostListingService.listOf(user.userId()));
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:../";
	}
	@RequestMapping(value="next", method=RequestMethod.POST)
	public String next(Model model, User user, RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:../../savings_goal";
	}

}
