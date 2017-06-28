package web.login;

import java.util.Calendar;

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

import model.balance.BalanceMonth;
import model.user.User;
import model.user.UserSummary;
import model.user.UserSummaryFactory;
import service.balance.BalanceCalcService;
import service.balance.BalanceCheckService;
import service.balance.BalanceRegisterService;
import service.income.IncomeCheckService;
import service.savings.goal.SavingsGoalCheckService;
import service.user.UserCheckService;
import service.user.UserFindService;

@Controller("loginController")
@RequestMapping("login")
@SessionAttributes("user")
public class LoginController {
	@Autowired
	private UserSummaryFactory userSummaryFactory;
	@Autowired
	private UserCheckService userCheckService;
	@Autowired
	private UserFindService userFindService;
	@Autowired
	private IncomeCheckService incomeCheckService;
	@Autowired
	private SavingsGoalCheckService savingsGoalCheckService;
	@Autowired
	private BalanceRegisterService balanceRegisterService;
	@Autowired
	private BalanceCheckService balanceCheckService;
	@Autowired
	private BalanceCalcService balanceCalcService;

	@RequestMapping
	public String login(Model model, WebRequest webRequest){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) != null){
			User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

			/*毎月の収入が設定されているか判定*/
			if(incomeCheckService.isNotExists(user.userId())) return "redirect:./register/income";
			/*毎月の貯金目標が設定されているか判定*/
			if(savingsGoalCheckService.isNotExists(user.userId())) return "redirect:./register/fixed_cost/list";
			/*今月の使用残高が設定されているか判定*/
			Calendar calendar = Calendar.getInstance();
			if(balanceCheckService.isNotExists(user.userId())){
				if(balanceCheckService.isExceeds(user.userId(), calendar.get(Calendar.DATE)))
					balanceRegisterService.register(user.userId(), balanceCalcService.differenceCalc(user.userId()), new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+2)));
				else balanceRegisterService.register(user.userId(), balanceCalcService.differenceCalc(user.userId()), new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+1)));
			}

			model.addAttribute("user", user);
			return "redirect:./top";
		}

		model.addAttribute("userSummary", userSummaryFactory.create());
		return "top/login";
	}

	@RequestMapping(value="check", method=RequestMethod.POST)
	public String loginCheck(Model model, @Valid @ModelAttribute("userSummary") UserSummary userSummary, Errors errors, WebRequest webRequest){

		if(errors.hasErrors()){
			return "top/login";
		}else if(userCheckService.isNotExists(userSummary.userMail(), userSummary.userPassword())){
			model.addAttribute("loginError", "メールアドレス、またはパスワードが間違っています。");
			return "top/login";
		}
		User user = userFindService.findBy(userSummary.userMail(), userSummary.userPassword());

		model.addAttribute("user", user);

		/*毎月の収入が設定されているか判定*/
		if(incomeCheckService.isNotExists(user.userId())) return "redirect:../register/income";
		/*毎月の貯金目標が設定されているか判定*/
		if(savingsGoalCheckService.isNotExists(user.userId())) return "redirect:../register/fixed_cost/list";
		/*今月の使用残高が設定されているか判定*/
		Calendar calendar = Calendar.getInstance();
		if(balanceCheckService.isNotExists(user.userId())){
			if(balanceCheckService.isExceeds(user.userId(), calendar.get(Calendar.DATE)))
				balanceRegisterService.register(user.userId(), balanceCalcService.differenceCalc(user.userId()), new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+2)));
			else balanceRegisterService.register(user.userId(), balanceCalcService.differenceCalc(user.userId()), new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+1)));
		}

		return "redirect:../top";
	}

	@RequestMapping(value="top")
	public String top(Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "forward:../login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);
		model.addAttribute("user", user);
		return "redirect:../top";
	}
}