package web.income;

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

import model.balance.Balance;
import model.balance.BalanceFactory;
import model.balance.BalanceMonth;
import model.income.Income;
import model.income.IncomeFactory;
import model.user.User;
import service.balance.BalanceRegisterService;
import service.income.IncomeCheckService;
import service.income.IncomeRegisterService;

@Controller("incomeRegisterController")
@RequestMapping(value="register/income")
@SessionAttributes("user")
public class IncomeRegisterController {
	@Autowired
	private IncomeRegisterService incomeRegisterService;
	@Autowired
	private IncomeFactory incomeFactory;
	@Autowired
	private IncomeCheckService incomeCheckService;
	@Autowired
	private BalanceFactory balanceFactory;
	@Autowired
	private BalanceRegisterService balanceRegisterService;



	@RequestMapping
	public String register( Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../login";
		}
		/*毎月の収入が設定されているか判定*/
		if(incomeCheckService.isExists(((User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION)).userId())) return "redirect:../fixed_cost/list";

		model.addAttribute("income", incomeFactory.create());
		model.addAttribute("balance", balanceFactory.create());
		return "income/income_register";

	}

	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute( Model model, @Valid @ModelAttribute("income") Income income, Errors incomeErrors, @Valid @ModelAttribute("balance") Balance balance, Errors balanceErrors, User user){

		if(incomeErrors.hasErrors()){
			return "income/income_register";
		}
		if(balanceErrors.hasErrors()){
			return "income/income_register";
		}

		/* 収入を登録 */
		incomeRegisterService.register(income, user.userId());

		Calendar calendar = Calendar.getInstance();
		if(Integer.valueOf(income.incomeRevenueDate().value()) > calendar.get(Calendar.DATE))
			balanceRegisterService.register(user.userId(), balance.balanceAmount(), new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+1)));
		else balanceRegisterService.register(user.userId(), balance.balanceAmount(), new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+2)));

		return "redirect:../fixed_cost/list";

	}

}
