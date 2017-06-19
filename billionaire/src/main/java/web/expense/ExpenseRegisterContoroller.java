package web.expense;

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

import model.dailybudget.DailyBudgetId;
import model.expense.Expense;
import model.expense.ExpenseFactory;
import model.user.User;
import service.dailybudget.DailyBudgetModifyService;
import service.expense.ExpenseRegisterService;

@Controller("expenseCostContoroller")
@RequestMapping("expense/register")
@SessionAttributes("user")
public class ExpenseRegisterContoroller {
	@Autowired
	private ExpenseFactory expenseFactory;
	@Autowired
	private ExpenseRegisterService expenseRegisterService;
	@Autowired
	private DailyBudgetModifyService dailyBudgetModifyService;

	@RequestMapping
	public String register(Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../login";
		}

		model.addAttribute("expense", expenseFactory.create());
		return "expense/expense_register";
	}
	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute(Model model, @Valid @ModelAttribute("expense") Expense expense, Errors errors, User user, WebRequest webRequest){

		if(errors.hasErrors()){
			return "expense/expense_register";
		}

		expenseRegisterService.register(expense, (DailyBudgetId) webRequest.getAttribute("dailyBudgetId", WebRequest.SCOPE_SESSION));
		dailyBudgetModifyService.modify((DailyBudgetId) webRequest.getAttribute("dailyBudgetId", WebRequest.SCOPE_SESSION), expense.expenseAmount());
		return "redirect:../list";
	}

}
