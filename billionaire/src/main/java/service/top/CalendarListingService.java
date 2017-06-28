package service.top;

import model.calendar.CalendarList;
import model.user.UserId;

public interface CalendarListingService {
	public CalendarList listOf(UserId userId, Integer value);
}
