package web.fixedcost;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.fixedcost.FixedCost;
import model.fixedcost.FixedCostFactory;
import model.user.User;
import service.fixedcost.FixedCostRegisterService;

@Controller("fixedCostContoroller")
@RequestMapping("register/fixed_cost")
@SessionAttributes("user")
public class FixedCostRegisterContoroller {
	@Autowired
	private FixedCostFactory fixedCostFactory;
	@Autowired
	private FixedCostRegisterService fixedCostRegisterService;

	@RequestMapping
	public String register(Model model, @ModelAttribute("user")User user){
		model.addAttribute("fixedCost", fixedCostFactory.create());
		return "setting/fixed_cost_register";
	}
	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute(Model model, @Valid @ModelAttribute("fixedCost") FixedCost fixedCost, Errors errors, User user, RedirectAttributes redirectAttributes){

		if(errors.hasErrors()){
			return "setting/fixed_cost_register";
		}

		fixedCostRegisterService.registerBy(fixedCost, user.userId());
		redirectAttributes.addFlashAttribute("user", user);

		return "redirect:./list";
	}

}
