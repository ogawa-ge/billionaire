package model.calendar;

import org.springframework.stereotype.Component;

@Component("calendarListFactory")
public class CalendarListFactory {
	public CalendarList create(){
		return new CalendarList();
	}
}
