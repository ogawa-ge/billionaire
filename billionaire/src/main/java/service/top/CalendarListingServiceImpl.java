package service.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.calendar.CalendarList;
import model.dailybudget.DailyBudgetRepository;
import model.user.UserId;

@Service("calendarListingService")
public class CalendarListingServiceImpl implements CalendarListingService{
	@Autowired
	private DailyBudgetRepository dailyBudgetRepository;

	@Override
	public CalendarList listOf(UserId userId){
		return dailyBudgetRepository.listOf(userId);
	}

}
