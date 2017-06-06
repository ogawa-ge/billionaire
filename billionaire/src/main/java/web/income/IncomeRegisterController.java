package web.income;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("register/income")
public class IncomeRegisterController {

	@RequestMapping
	public String helthCheck( Model model ){
		model.addAttribute("sample_test", "OK!!!");
		return "sample";
	}
}
