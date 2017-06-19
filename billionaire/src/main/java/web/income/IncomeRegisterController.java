package web.income;

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

import model.income.Income;
import model.income.IncomeFactory;
import model.user.User;
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



	@RequestMapping
	public String register( Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../login";
		}
		/*毎月の収入が設定されているか判定*/
		if(incomeCheckService.isExists(((User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION)).userId())) return "redirect:../savings_goal";

		model.addAttribute("income", incomeFactory.create());
		return "income/income_register";

	}

	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute( Model model,@Valid @ModelAttribute("income") Income income, Errors errors, User user){

		if(errors.hasErrors()){
			return "income/income_register";
		}

		/* 収入を登録 */
		incomeRegisterService.register(income, user.userId());

		return "redirect:../fixed_cost/list";

	}

}
