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
import org.springframework.web.context.request.WebRequest;

import model.fixedcost.FixedCost;
import model.fixedcost.FixedCostFactory;
import model.user.User;
import service.fixedcost.FixedCostRegisterService;

@Controller("fixedCostRegisterContoroller")
@RequestMapping("register/fixed_cost")
@SessionAttributes("user")
public class FixedCostRegisterContoroller {
	@Autowired
	private FixedCostFactory fixedCostFactory;
	@Autowired
	private FixedCostRegisterService fixedCostRegisterService;

	@RequestMapping
	public String register(Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../../login";
		}

		model.addAttribute("fixedCost", fixedCostFactory.create());
		return "fixed_cost/fixed_cost_register";
	}
	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute(Model model, @Valid @ModelAttribute("fixedCost") FixedCost fixedCost, Errors errors, User user){

		if(errors.hasErrors()){
			return "fixed_cost/fixed_cost_register";
		}

		fixedCostRegisterService.register(fixedCost, user.userId());
		return "redirect:./list";
	}

}
