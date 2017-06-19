package web.expense;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.dailybudget.DailyBudgetDate;
import model.user.User;
import service.dailybudget.DailyBudgetFindService;
import service.expense.ExpenseListingService;

@Controller("expenseListingController")
@RequestMapping("expense/list")
@SessionAttributes("user")
public class ExpenseListingController {
	@Autowired
	private ExpenseListingService expenseListingService;
	@Autowired
	private DailyBudgetFindService dailyBudgetFindService;

	@RequestMapping
	public String listing(Model model, WebRequest webRequest ){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:../login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");


		model.addAttribute("date", simpleDateFormat.format(calendar.getTime()));
        model.addAttribute("dailyBudget", dailyBudgetFindService.findBy(user.userId(),
        																new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))));

        model.addAttribute("expenseList", expenseListingService.listOf(dailyBudgetFindService.findBy(user.userId(),
        																							new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))).dailyBudgetId()));

        Integer totalAmount = expenseListingService.findTotal(dailyBudgetFindService.findBy(user.userId(),
						new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))).dailyBudgetId());

        if(totalAmount != null)
        	model.addAttribute("expenseTotal", totalAmount);
        else
        	model.addAttribute("expenseTotal", "---");

        webRequest.setAttribute("dailyBudgetId", dailyBudgetFindService.findBy(user.userId(), new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))).dailyBudgetId(), WebRequest.SCOPE_SESSION);

        return "expense/expense_list";
	}
	@RequestMapping(value="{date}")
	public String listingBy(Model model, WebRequest webRequest, @PathVariable("date")String date){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "forward:../login";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		Calendar calendar = Calendar.getInstance();
		Integer year = Integer.parseInt(date.substring(0, 4));
		Integer month = Integer.parseInt(date.substring(4, 6));
		Integer day = Integer.parseInt(date.substring(6, 8));
		calendar.set(year, month - 1, day);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");


		model.addAttribute("date", simpleDateFormat.format(calendar.getTime()));
        model.addAttribute("dailyBudget", dailyBudgetFindService.findBy(user.userId(),
        																new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))));

        model.addAttribute("expenseList", expenseListingService.listOf(dailyBudgetFindService.findBy(user.userId(),
        																							new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))).dailyBudgetId()));

        Integer totalAmount = expenseListingService.findTotal(dailyBudgetFindService.findBy(user.userId(),
						new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))).dailyBudgetId());

        if(totalAmount != null)
        	model.addAttribute("expenseTotal", totalAmount);
        else
        	model.addAttribute("expenseTotal", "---");

        webRequest.setAttribute("dailyBudgetId", dailyBudgetFindService.findBy(user.userId(), new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))).dailyBudgetId(), WebRequest.SCOPE_SESSION);

        return "expense/expense_list";
	}
}
