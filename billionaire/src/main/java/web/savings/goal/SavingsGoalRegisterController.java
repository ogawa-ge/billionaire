package web.savings.goal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.savings.goal.SavingsGoal;
import model.savings.goal.SavingsGoalFactory;
import model.user.User;
import service.savings.goal.SavingsGoalCheckService;
import service.savings.goal.SavingsGoalRegisterService;

@Controller("savingsGoalRegisterController")
@RequestMapping(value="register/savings_goal")
@SessionAttributes("user")
public class SavingsGoalRegisterController {
	@Autowired
	private SavingsGoalRegisterService savingsGoalRegisterService;
	@Autowired
	private SavingsGoalFactory savingsGoalFactory;
	@Autowired
	private SavingsGoalCheckService savingsGoalCheckService;
//	@Autowired
//	private BalanceCheckService balanceCheckService;
//	@Autowired
//	private BalanceRegisterService balanceRegisterService;
//	@Autowired
//	private BalanceCalcService balanceCalcService;

	@RequestMapping
	public String register(Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);
		/*毎月の貯金目標が設定されているか判定*/
		if(savingsGoalCheckService.isExists(user.userId())) return "redirect:../top";

		model.addAttribute("savingsGoal", savingsGoalFactory.create(user.userId()));
		return "savings_goal/savings_goal_register";
	}

	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute(Model model, @Valid @ModelAttribute("savingsGoal") SavingsGoal savingsGoal, Errors errors, User user){

		if(errors.hasErrors()){
			return "savings_goal/savings_goal_register";
		}

		/*毎月の貯金目標登録*/
		savingsGoalRegisterService.register(savingsGoal, user.userId());

		/*今月の使用残高が設定されているか判定*/
//		Calendar calendar = Calendar.getInstance();
//		if(balanceCheckService.isExceeds(user.userId(), calendar.get(Calendar.DATE)))
//			balanceRegisterService.register(user.userId(), balanceCalcService.differenceCalc(user.userId()), new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+2)));
//		else balanceRegisterService.register(user.userId(), balanceCalcService.differenceCalc(user.userId()), new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+1)));

		return "redirect:../../top";
	}
}
