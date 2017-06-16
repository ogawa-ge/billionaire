package model.calendar;

import java.io.Serializable;

import model.dailybudget.Budget;

public class CalendarDailyDetail implements Serializable{
	private CalendarDetailDate calendarDetailDate;
	private Budget budget;

	public CalendarDailyDetail(CalendarDetailDate calendarDetailDate, Budget budget){
		this.calendarDetailDate = calendarDetailDate;
		this.budget = budget;
	}
	public CalendarDailyDetail(CalendarDetailDate calendarDetailDate){
		this.calendarDetailDate = calendarDetailDate;
		budget = new Budget();
	}
	public CalendarDailyDetail(){
		calendarDetailDate = new CalendarDetailDate();
		budget = new Budget();
	}

	@Deprecated
	public CalendarDetailDate getCalendarDetailDate(){
		return calendarDetailDate;
	}
	@Deprecated
	public Budget getBudget(){
		return budget;
	}

	@Override
	public String toString() {
		return String.format("DailyDetail [calendarDetailDate=%s, budget=%s]", calendarDetailDate, budget);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 3213943966462192445L;
}
