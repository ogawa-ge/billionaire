package datasource.dailybudget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.calendar.CalendarDailyDetail;
import model.calendar.CalendarDetailDate;
import model.calendar.CalendarList;
import model.dailybudget.Budget;
import model.dailybudget.DailyBudget;
import model.dailybudget.DailyBudgetDate;
import model.dailybudget.DailyBudgetId;
import model.dailybudget.DailyBudgetRepository;
import model.expense.ExpenseAmount;
import model.user.UserId;

@Repository("dailyBudgetRepository")
public class DailyBudgetDataAccess implements DailyBudgetRepository{
	@Autowired
	public DailyBudgetMapper dailyBudgetMapper;

	@Override
	public DailyBudget findBy(UserId userId, DailyBudgetDate dailyBudgetDate) {
		return dailyBudgetMapper.findBy(userId, dailyBudgetDate);
	}

	@Override
	public void register(UserId userId, DailyBudgetDate dailyBudgetDate, Budget budget) {
		dailyBudgetMapper.register(userId, dailyBudgetDate, budget);
	}

	@Override
	public void modify(DailyBudgetId dailyBudgetId, ExpenseAmount expenseAmount) {
		dailyBudgetMapper.modify(dailyBudgetId, expenseAmount);
	}

	@Override
	public DailyBudgetId findLastId(UserId userId) {
		return dailyBudgetMapper.findLastId(userId);
	}

	@Override
	public CalendarList listOf(UserId userId) {
		List<CalendarDailyDetail> calendarList = new ArrayList<CalendarDailyDetail>();

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Integer year = calendar.get(Calendar.YEAR);
		Integer month = calendar.get(Calendar.MONTH);
		Integer count = 0;

		/* 今月が何曜日から開始されているか確認する */
		calendar.set(year, month, 1);
		Integer startWeek = calendar.get(Calendar.DAY_OF_WEEK);

		/* 先月が何日までだったかを確認する */
		calendar.set(year, month, 0);
		Integer beforeMonthlastDay = calendar.get(Calendar.DATE);

		/* 今月が何日までかを確認する */
		calendar.set(year, month + 1, 0);
		Integer thisMonthlastDay = calendar.get(Calendar.DATE);

		/* 先月分の日付を格納する */
		for (Integer i = startWeek - 2 ; i >= 0 ; i--){
			calendar.set(year, month - 1, beforeMonthlastDay - i);
			calendarList.add((CalendarDailyDetail) dailyBudgetMapper.listOf(userId, simpleDateFormat.format(calendar.getTime())));
			if(calendarList.get(count) == null)
				calendarList.set(count, new CalendarDailyDetail(new CalendarDetailDate(Integer.toString(calendar.get(Calendar.YEAR)),
																						Integer.toString(calendar.get(Calendar.MONTH)),
																						Integer.toString(calendar.get(Calendar.DATE)))));
			count++;
		}

		/* 今月分の日付を格納する */
		for (Integer i = 1 ; i <= thisMonthlastDay ; i++){
			calendar.set(year, month, i);
			calendarList.add(dailyBudgetMapper.listOf(userId, simpleDateFormat.format(calendar.getTime())));
			if(calendarList.get(count) == null)
				calendarList.set(count, new CalendarDailyDetail(new CalendarDetailDate(Integer.toString(calendar.get(Calendar.YEAR)),
																						Integer.toString(calendar.get(Calendar.MONTH)),
																						Integer.toString(calendar.get(Calendar.DATE)))));
			count++;
		}

		/* 翌月分の日付を格納する */
		Integer nextMonthDay = 1;
		while (count % 7 != 0){
			calendar.set(year, month, nextMonthDay++);
			calendarList.add(dailyBudgetMapper.listOf(userId, simpleDateFormat.format(calendar.getTime())));
			if(calendarList.get(count) == null)
				calendarList.set(count, new CalendarDailyDetail(new CalendarDetailDate(Integer.toString(calendar.get(Calendar.YEAR)),
																						Integer.toString(calendar.get(Calendar.MONTH)),
																						Integer.toString(calendar.get(Calendar.DATE)))));
			count++;
		}

		for(Integer i = 0 ; i < calendarList.size() ; i++){
		}

		return new CalendarList(calendarList);
	}

}
