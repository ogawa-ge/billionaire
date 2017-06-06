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

import model.income.Income;
import model.income.IncomeFactory;
import model.user.User;
import service.income.IncomeRegisterService;

@Controller
@RequestMapping(value="register/income")
@SessionAttributes("user")
public class IncomeRegisterController {
	@Autowired
	IncomeRegisterService incomeRegisterService;
	@Autowired
	IncomeFactory incomeFactory;


	@RequestMapping(value="test")
	public String helthCheck( Model model ){
		model.addAttribute("sample_test", "OK!!!");
		return "sample";
	}

	@RequestMapping
	public String register( Model model ){

		/*テスト用
		User user = new User(new UserId(1), new UserMail("test@genuine-pt.jp"), new UserName("テスト"), new UserPassword("genuine"));*/
		model.addAttribute("income", incomeFactory.create());
		return "setting/income_register";

	}

	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute( Model model,@Valid @ModelAttribute("income") Income income, Errors errors, User user){

		if(errors.hasErrors()){
			return "setting/income_register";
		}

		/* 収入を登録 */
		incomeRegisterService.register(income, user.userId());

		return "redirect:../savings_goal";

	}

}
