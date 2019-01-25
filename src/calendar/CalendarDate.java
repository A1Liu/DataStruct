package calendar;

public class CalendarDate {
	
	private int month;
	private int day;
	private int year;
	
	/**
	 * default constructor
	 */
	public CalendarDate() {
		month = 1;
		day = 1;
		year = 2018;
	}
	
	/**
	 * Constructor for when the user has a date in mind
	 * @param monthPar
	 * @param dayPar
	 * @param yearPar
	 */
	public CalendarDate(int monthPar, int dayPar, int yearPar) {
		month = monthPar;
		day = dayPar;
		year = yearPar;
		if (!checkValid(month,day,year)){
			month = 1;
			day = 1;
			year = 2018;
		}
	}
	
	
	/**
	 * @param monthPar
	 * @param dayPar
	 * @param yearPar
	 * @return true for if its valid, false when its not valid
	 */
	public boolean checkValid(int monthPar, int dayPar, int yearPar) {
	if (monthPar >12 || monthPar <1) {
		return false;
	}
	if ( yearPar < 0 || dayPar < 1 || dayPar > numDays(monthPar, yearPar)) {
		return false;
	}
	return true;
	}
	
	/**
	 * @param monthPar
	 * @param yearPar
	 * @return number of days in the month
	 */
	public int numDays(int monthPar, int yearPar) {
		switch(monthPar)
		{
		case 2:
			return isLeapYear(yearPar) ? 29 : 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}
	
	/**
	 * @param yearPar
	 * @return whether or not the year is a leap year
	 */
	public boolean isLeapYear(int yearPar) {
		if (yearPar % 400 == 0) return true;
		if (yearPar % 100 == 0) return false;
		if (yearPar % 4 == 0) return true;
		return false;
	}
	
	/**
	 * @param monthPar
	 * @return name of the month for a specific month number
	 */
	public String monthToString(int monthPar) {
		final String[] monthList = {"January","February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		if(monthPar<0 || monthPar >12) {
			return "January";
		}
		
		return monthList[monthPar-1];
	}
	
	/**
	 * @return string of next date
	 */
	public String nextDate(){
		int dayNext=day+1; int monthNext=month; int yearNext=year;
		if (day == numDays(month,year)) {
			dayNext = 1;
			monthNext = month+1;
		}
		if (month == 12){
			monthNext = 1;
			yearNext = year+1;
		}
		return monthToString(monthNext) + " " + dayNext + ", " + yearNext;
	}
	
	/**
	 * @return string of previous date
	 */
	public String prevDate() {
		int dayPrev=day-1;int monthPrev=month; int yearPrev=year;
		if (day ==1){
			dayPrev = numDays(month-1,year);
			monthPrev = month - 1;
			if (month == 1){
				monthPrev = 12;
				yearPrev = year-1;
				dayPrev = numDays(monthPrev, yearPrev);
			}
		}
		return monthToString(monthPrev) + " " + dayPrev + ", " + yearPrev;
	}
	
	/**
	 * @return string out of the calendarDate
	 */
	public String toString() {
		return monthToString(month) + " " + day + ", " + year;
	}
	
	/**
	 * @return day of week for calendar date
	 */
	public String dayOfWeek() {
		final String[] daysName = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		int yearGauss = year-1;
		int janOne = (1+5*(yearGauss % 4)+ 4*(yearGauss % 100) + 6*(yearGauss % 400)) % 7;
		int indexOfDate = 0;
		for(int x=1;x<month;x++) {
			indexOfDate+=numDays(x,year);
		}
		indexOfDate+=day-1;
		int dayOfWeek = (janOne + indexOfDate) % 7;
		return daysName[dayOfWeek];
	}
	
}
