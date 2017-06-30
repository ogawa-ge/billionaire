package web.income;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.income.Income;
import model.user.User;
import service.income.IncomeFindService;
import service.income.IncomeModifyService;

@Controller("incomeModifyController")
@RequestMapping("setting/income")
@SessionAttributes("user")
public class IncomeModifyController {
	@Autowired
	private IncomeFindService incomeFindService;
	@Autowired
	private IncomeModifyService incomeModifyService;

	@RequestMapping("modify")
	public String modify(Model model, WebRequest webRequest){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:./login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		model.addAttribute("income", incomeFindService.findBy(user.userId()));

		return "setting/setting_income_modify";
	}

	@RequestMapping("execute")
	public String execute(Model model, @Valid @ModelAttribute("income") Income income, Errors errors, WebRequest webRequest){
		if(errors.hasErrors()){
			return "income/income_register";
		}
		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		incomeModifyService.modify(user.userId(), income);

		model.addAttribute("income", incomeFindService.findBy(user.userId()));

		return "setting/setting_list";
	}
}
