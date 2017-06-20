package web.top;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import model.balance.BalanceMonth;
import model.dailybudget.Budget;
import model.dailybudget.DailyBudgetDate;
import model.savings.performance.SavingsPerformanceFactory;
import model.user.User;
import model.user.UserSummaryFactory;
import service.balance.BalanceCalcService;
import service.balance.BalanceCheckService;
import service.balance.BalanceFindService;
import service.balance.BalanceModifyService;
import service.dailybudget.DailyBudgetCheckService;
import service.dailybudget.DailyBudgetFindService;
import service.dailybudget.DailyBudgetRegisterService;
import service.income.IncomeCheckService;
import service.income.IncomeFindService;
import service.savings.goal.SavingsGoalFindService;
import service.savings.performance.SavingsPerformanceRegisterService;
import service.top.CalendarListingService;

@Controller("topController")
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
	private CalendarListingService calendarListingService;
	@Autowired
	private UserSummaryFactory userSummaryFactory;
	@Autowired
	private SavingsPerformanceRegisterService savingsPerformanceRegisterService;
	@Autowired
	private SavingsPerformanceFactory savingsPerformanceFactory;
	@Autowired
	private SavingsGoalFindService savingsGoalFindService;

	@RequestMapping(value="/")
	public String index(Model model){
		model.addAttribute("userSummary", userSummaryFactory.create());

		return "top/index";
	}

	@RequestMapping("top")
	public String top(Model model, WebRequest webRequest){
		if(webRequest.getAttribute("user", WebRequest.SCOPE_SESSION) == null){
			return "redirect:./";
		}

		User user = (User) webRequest.getAttribute("user", WebRequest.SCOPE_SESSION);

		Integer balanceAmount = Integer.parseInt(balanceFindService.findBy(user.userId()).balanceAmount().value());

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar nextRevenueDateCalendar = Calendar.getInstance();
		nextRevenueDateCalendar.set(Calendar.DATE, Integer.parseInt(incomeFindService.findBy(user.userId()).incomeRevenueDate().value()));

		if(balanceCheckService.isExceeds(user.userId(), calendar.get(Calendar.DATE)))
			nextRevenueDateCalendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);

		if(dailyBudgetCheckService.isNotExists(user.userId(), new DailyBudgetDate(simpleDateFormat.format(calendar.getTime())))){
	        Long diffTime = nextRevenueDateCalendar.getTimeInMillis() - calendar.getTimeInMillis();
	        Integer MILLIS_OF_DAY = 1000 * 60 * 60 * 24;
	        Integer diffDays = (int)(diffTime / MILLIS_OF_DAY);
	        Integer dailyBudget = balanceAmount / diffDays;

	        dailyBudgetRegisterService.register(user.userId(),
        										new DailyBudgetDate(simpleDateFormat.format(calendar.getTime())),
        										new Budget(dailyBudget.toString()));
        }


		if(incomeCheckService.isExceeds(user.userId(), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DATE))){
			Integer savingsGoalAmount = Integer.parseInt(savingsGoalFindService.findBy(user.userId()).savingsGoalAmount().value());
			Integer savingsPerformanceAmount = balanceAmount + savingsGoalAmount;

			savingsPerformanceRegisterService.register(user.userId(),
														savingsPerformanceFactory.create(simpleDateFormat.format(calendar.getTime()),
																						savingsPerformanceAmount.toString(),
																						savingsGoalAmount.toString()));
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
