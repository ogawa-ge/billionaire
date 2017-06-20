package web.expense;

import java.text.SimpleDateFormat;
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

import model.balance.BalanceAmount;
import model.dailybudget.DailyBudgetId;
import model.expense.Expense;
import model.expense.ExpenseFactory;
import model.user.User;
import service.balance.BalanceFindService;
import service.balance.BalanceModifyService;
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
	@Autowired
	private BalanceFindService balanceFindService;
	@Autowired
	private BalanceModifyService balanceModifyService;

	@RequestMapping
	public String register(Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../login";
		}

		Calendar calendar = (Calendar) webRequest.getAttribute("expenseDate", WebRequest.SCOPE_SESSION);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat escapeSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		model.addAttribute("date", simpleDateFormat.format(calendar.getTime()));
		model.addAttribute("escape", escapeSimpleDateFormat.format(calendar.getTime()));
		model.addAttribute("expense", expenseFactory.create());
		return "expense/expense_register";
	}
	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute(Model model, @Valid @ModelAttribute("expense") Expense expense, Errors errors, User user, WebRequest webRequest){

		if(errors.hasErrors()){
			Calendar calendar = (Calendar) webRequest.getAttribute("expenseDate", WebRequest.SCOPE_SESSION);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

			model.addAttribute("date", simpleDateFormat.format(calendar.getTime()));
			return "expense/expense_register";
		}

        Integer balanceAmount = Integer.parseInt(balanceFindService.findBy(user.userId()).balanceAmount().value());
    	balanceAmount -= Integer.parseInt(expense.expenseAmount().value());

		Calendar calendar = (Calendar) webRequest.getAttribute("expenseDate", WebRequest.SCOPE_SESSION);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		expenseRegisterService.register(expense, (DailyBudgetId) webRequest.getAttribute("dailyBudgetId", WebRequest.SCOPE_SESSION));
        balanceModifyService.modifyAmount(user.userId(), new BalanceAmount(balanceAmount.toString()));
		dailyBudgetModifyService.modify((DailyBudgetId) webRequest.getAttribute("dailyBudgetId", WebRequest.SCOPE_SESSION), expense.expenseAmount());
		return "redirect:../list/" + simpleDateFormat.format(calendar.getTime());
	}

}
