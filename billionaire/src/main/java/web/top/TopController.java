package web.top;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.balance.BalanceAmount;
import model.balance.BalanceMonth;
import model.dailybudget.Budget;
import model.dailybudget.DailyBudgetDate;
import model.dailybudget.DailyBudgetId;
import model.user.User;
import service.balance.BalanceCalcService;
import service.balance.BalanceCheckService;
import service.balance.BalanceFindService;
import service.balance.BalanceModifyService;
import service.dailybudget.DailyBudgetCheckService;
import service.dailybudget.DailyBudgetFindService;
import service.dailybudget.DailyBudgetRegisterService;
import service.expense.ExpenseListingService;
import service.income.IncomeCheckService;
import service.income.IncomeFindService;
import service.top.CalendarListingService;

@Controller("topController")
@RequestMapping("top")
@SessionAttributes("user")
public class TopController {
	@Autowired
	private IncomeCheckService incomeCheckService;
	@Autowired
	private IncomeFindService incomeFindService;
	@Autowired
	private BalanceModifyService balanceModifyService;
	@Autowired
	private BalanceCheckService balanceCheckService;
	@Autowired
	private BalanceCalcService balanceCalcService;
	@Autowired
	private BalanceFindService balanceFindService;
	@Autowired
	private DailyBudgetCheckService dailyBudgetCheckService;
	@Autowired
	private DailyBudgetRegisterService dailyBudgetRegisterService;
	@Autowired
	private DailyBudgetFindService dailyBudgetFindService;
	@Autowired
	private ExpenseListingService expenseListingService;
	@Autowired
	private CalendarListingService calendarListingService;

	@RequestMapping
	public String top(Model model, WebRequest webRequest){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "top/index";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar nextRevenueDateCalendar = Calendar.getInstance();
		nextRevenueDateCalendar.set(Calendar.DATE, Integer.parseInt(incomeFindService.findBy(user.userId()).incomeRevenueDate().value()));
		nextRevenueDateCalendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));

		if(balanceCheckService.isExceeds(user.userId(), calendar.get(Calendar.DATE)))
			nextRevenueDateCalendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);

		if(dailyBudgetCheckService.isNotExists(user.userId(), new DailyBudgetDate(simpleDateFormat.format(calendar.getTime())))){
        	DailyBudgetId dailyBudgetLastId = dailyBudgetFindService.findLastId(user.userId());
	        Integer balanceAmount = Integer.parseInt(balanceFindService.findBy(user.userId()).balanceAmount().value());

	        if(expenseListingService.findTotal(dailyBudgetLastId) != null)
        		balanceAmount -= expenseListingService.findTotal(dailyBudgetLastId);

	        balanceModifyService.modifyAmount(user.userId(), new BalanceAmount(balanceAmount.toString()));

	        Long diffTime = nextRevenueDateCalendar.getTimeInMillis() - calendar.getTimeInMillis();
	        Integer MILLIS_OF_DAY = 1000 * 60 * 60 * 24;
	        Integer diffDays = (int)(diffTime / MILLIS_OF_DAY);
	        Integer dailyBudget = balanceAmount / diffDays;

	        dailyBudgetRegisterService.register(user.userId(),
        										new DailyBudgetDate(simpleDateFormat.format(calendar.getTime())),
        										new Budget(dailyBudget.toString()));
        }


		if(incomeCheckService.isExceeds(user.userId(), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DATE))){
			if(balanceCheckService.isExceeds(user.userId(), calendar.get(Calendar.DATE))){
				balanceModifyService.modify(user.userId(),
											balanceCalcService.differenceCalc(user.userId()),
											new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+2)));
			}else{
				balanceModifyService.modify(user.userId(),
											balanceCalcService.differenceCalc(user.userId()),
											new BalanceMonth(String.valueOf(calendar.get(Calendar.MONTH)+1)));
			}
		}

		model.addAttribute("dailyBudget", dailyBudgetFindService.findBy(user.userId(),
																	new DailyBudgetDate(simpleDateFormat.format(calendar.getTime()))));
		model.addAttribute("balance", balanceFindService.findBy(user.userId()));
		model.addAttribute("date", simpleDateFormat.format(calendar.getTime()));
		model.addAttribute("calendarList", calendarListingService.listOf(user.userId()));

		return "top/top";
	}

}
