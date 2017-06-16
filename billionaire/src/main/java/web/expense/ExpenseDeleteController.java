package web.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.dailybudget.DailyBudgetId;
import model.expense.ExpenseAmount;
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

	@RequestMapping(method=RequestMethod.POST)
	public String delete(@RequestParam("expenseId") Integer expenseId, WebRequest webRequest){
		Integer expenseAmount = Integer.parseInt(expenseFindService.findBy(expenseId).expenseAmount().value()) * -1;
		dailyBudgetModifyService.modify((DailyBudgetId) webRequest.getAttribute("dailyBudgetId", WebRequest.SCOPE_SESSION),
										new ExpenseAmount(expenseAmount.toString()));
		expenseDeleateService.delete(expenseId);
		return "redirect:./list";
	}
}
