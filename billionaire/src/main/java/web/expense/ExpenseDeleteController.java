package web.expense;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.balance.BalanceAmount;
import model.dailybudget.DailyBudgetId;
import model.expense.ExpenseAmount;
import model.user.User;
import service.balance.BalanceFindService;
import service.balance.BalanceModifyService;
import service.dailybudget.DailyBudgetModifyService;
import service.expense.ExpenseDeleateService;
import service.expense.ExpenseFindService;

@Controller("expenseDeleteController")
@RequestMapping("expense/delete")
@SessionAttributes("user")
public class ExpenseDeleteController {
	@Autowired
	private ExpenseFindService expenseFindService;
	@Autowired
	private ExpenseDeleateService expenseDeleateService;
	@Autowired
	private DailyBudgetModifyService dailyBudgetModifyService;
	@Autowired
	private BalanceFindService balanceFindService;
	@Autowired
	private BalanceModifyService balanceModifyService;

	@RequestMapping(method=RequestMethod.POST)
	public String delete(@RequestParam("expenseId") Integer expenseId, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);
		Calendar calendar = (Calendar) webRequest.getAttribute("expenseDate", WebRequest.SCOPE_SESSION);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Integer expenseAmount = Integer.valueOf(expenseFindService.findBy(expenseId).expenseAmount().value()) * -1;

        Integer balanceAmount = Integer.valueOf(balanceFindService.findBy(user.userId()).balanceAmount().value());
    	balanceAmount -= expenseAmount;

		dailyBudgetModifyService.modify((DailyBudgetId) webRequest.getAttribute("dailyBudgetId", WebRequest.SCOPE_SESSION),
										new ExpenseAmount(expenseAmount.toString()));
        balanceModifyService.modifyAmount(user.userId(), new BalanceAmount(balanceAmount.toString()));
		expenseDeleateService.delete(expenseId);
		return "redirect:./list/" + simpleDateFormat.format(calendar.getTime());
	}
}
