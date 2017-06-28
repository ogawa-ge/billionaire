package model.calendar;

import java.io.Serializable;

public class CalendarDetailDate implements Serializable{
	private String year;
	private String month;
	private String day;

	public CalendarDetailDate(String year, String month, String day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public CalendarDetailDate(){
		year = "-";
		month = "-";
		day = "-";
	}

	public String year(){
		return year;
	}
	public String month(){
		return month;
	}
	public String day(){
		return day;
	}

	@Deprecated
	public void setYear(String year){
		this.year = year;
	}
	@Deprecated
	public void setMonth(String month){
		this.month = month;
	}
	@Deprecated
	public void setDay(String day){
		this.day = day;
	}
	@Deprecated
	public String getYear(){
		return year;
	}
	@Deprecated
	public String getMonth(){
		return month;
	}
	@Deprecated
	public String getDay(){
		return day;
	}

	@Override
	public String toString() {
		return String.format("CalendarDetailDate [year=%s, month=%s, day=%s]", year, month, day);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -1148926252260191851L;

}
