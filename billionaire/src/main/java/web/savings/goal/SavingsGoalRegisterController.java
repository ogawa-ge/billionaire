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

import model.savings.goal.SavingsGoal;
import model.savings.goal.SavingsGoalFactory;
import model.user.User;
import service.savings.goal.SavingsGoalRegisterService;

@Controller("savingsGoalRegisterController")
@RequestMapping(value="register/savings_goal")
@SessionAttributes("user")
public class SavingsGoalRegisterController {
	@Autowired
	SavingsGoalRegisterService savingsGoalRegisterService;
	@Autowired
	SavingsGoalFactory savingsGoalFactory;

	@RequestMapping
	public String register(Model model){
		model.addAttribute("savingsGoal", savingsGoalFactory.create());
		return "setting/savings_goal_register";
	}
	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute(Model model, @Valid @ModelAttribute("savingsGoal") SavingsGoal savingsGoal, Errors errors, User user){

		if(errors.hasErrors()){
			return "setting/savings_goal_register";
		}

		/*毎月の貯金目標登録*/
		//savingsGoalRegisterService.registerBy(savingsGoal, user.userId());

		return "redirect:../fixed_cost_list";
	}


}
