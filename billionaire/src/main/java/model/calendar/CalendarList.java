package model.calendar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CalendarList implements Serializable{
	private List<CalendarDailyDetail> calendarDailyDetailList;

	public CalendarList(List<CalendarDailyDetail> calendarDailyDetailList){
		this.calendarDailyDetailList = calendarDailyDetailList;
	}
	public CalendarList(){
		calendarDailyDetailList = new ArrayList<CalendarDailyDetail>();
	}

	@Deprecated
	public List<CalendarDailyDetail> getCalendarDailyDetailList(){
		return calendarDailyDetailList;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -813513545768379546L;
}