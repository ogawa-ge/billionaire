package web.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.user.User;
import service.fixedcost.FixedCostListingService;
import service.income.IncomeFindService;
import service.savings.goal.SavingsGoalFindService;

@Controller("settingListingController")
@RequestMapping("setting")
@SessionAttributes("user")
public class SettingListingController {
	@Autowired
	private IncomeFindService incomeFindService;
	@Autowired
	private FixedCostListingService fixedCostListingService;
	@Autowired
	private SavingsGoalFindService savingsGoalFindService;

	@RequestMapping
	public String setting(Model model, WebRequest webRequest){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:./login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		model.addAttribute("income", incomeFindService.findBy(user.userId()));
		model.addAttribute("fixedCostTotal", fixedCostListingService.findTotal(user.userId()));
		model.addAttribute("savingsGoal", savingsGoalFindService.findBy(user.userId()));

		return "setting/setting_list";
	}
}
