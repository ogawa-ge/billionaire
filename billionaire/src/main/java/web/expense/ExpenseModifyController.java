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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.balance.BalanceAmount;
import model.dailybudget.DailyBudgetId;
import model.expense.Expense;
import model.expense.ExpenseAmount;
import model.user.User;
import service.balance.BalanceFindService;
import service.balance.BalanceModifyService;
import service.dailybudget.DailyBudgetModifyService;
import service.expense.ExpenseFindService;
import service.expense.ExpenseModifyService;

@Controller("expenseModifiController")
@RequestMapping("expense/modify")
@SessionAttributes("user")
public class ExpenseModifyController {
	@Autowired
	private ExpenseFindService expenseFindService;
	@Autowired
	private ExpenseModifyService expenseModifyService;
	@Autowired
	private DailyBudgetModifyService dailyBudgetModifyService;
	@Autowired
	private BalanceFindService balanceFindService;
	@Autowired
	private BalanceModifyService balanceModifyService;

	@RequestMapping(method=RequestMethod.POST, params="expenseId")
	public String modify(Model model, @RequestParam("expenseId") Integer expenseId, @ModelAttribute("user") User user, WebRequest webRequest){
		Calendar calendar = (Calendar) webRequest.getAttribute("expenseDate", WebRequest.SCOPE_SESSION);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat escapeSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		model.addAttribute("date", simpleDateFormat.format(calendar.getTime()));
		model.addAttribute("escape", escapeSimpleDateFormat.format(calendar.getTime()));
		model.addAttribute("expense", expenseFindService.findBy(expenseId));
		return "expense/expense_modify";
	}

	@RequestMapping(value="execute", method=RequestMethod.POST)
	public String registerExecute(Model model, @RequestParam("expenseId.value") Integer expenseId, @Valid @ModelAttribute("expense") Expense expense, Errors errors, WebRequest webRequest){

		if(errors.hasErrors()){
			model.addAttribute("expense", expenseFindService.findBy(expense.expenseId().value()));
			return "expense/expense_modify";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);
		Calendar calendar = (Calendar) webRequest.getAttribute("expenseDate", WebRequest.SCOPE_SESSION);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Integer newExpenseAmount = Integer.parseInt(expense.expenseAmount().value());
		Integer oldExpenseAmount = Integer.parseInt(expenseFindService.findBy(expenseId).expenseAmount().value());
		Integer expenseAmount = (newExpenseAmount - oldExpenseAmount);

        Integer balanceAmount = Integer.parseInt(balanceFindService.findBy(user.userId()).balanceAmount().value());
    	balanceAmount -= expenseAmount;

		dailyBudgetModifyService.modify((DailyBudgetId) webRequest.getAttribute("dailyBudgetId", WebRequest.SCOPE_SESSION),
										new ExpenseAmount(expenseAmount.toString()));
        balanceModifyService.modifyAmount(user.userId(), new BalanceAmount(balanceAmount.toString()));
		expenseModifyService.modify(expense);
		return "redirect:../list/" + simpleDateFormat.format(calendar.getTime());
	}
}
