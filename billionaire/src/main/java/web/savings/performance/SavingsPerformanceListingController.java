package web.savings.performance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.user.User;
import service.savings.performance.SavingsPerformanceListingService;

@Controller("savingsPerformanceListingController")
@RequestMapping("savings_performance/list")
@SessionAttributes("user")
public class SavingsPerformanceListingController {
	@Autowired
	private SavingsPerformanceListingService savingsPerformanceListingService;

	@RequestMapping
	public String listing(Model model, WebRequest webRequest){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		model.addAttribute("savingsPerformanceList", savingsPerformanceListingService.listOf(user.userId()));
		model.addAttribute("savingsPerformanceTotal", savingsPerformanceListingService.findTotal(user.userId()));

		return "savings_performance/savings_performance_list";
	}
}
