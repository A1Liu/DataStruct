package calendar;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		CalendarDate defaultDate = new CalendarDate();
		CalendarDate january31 = new CalendarDate(1,31,2018);
		CalendarDate today = new CalendarDate(1,24,2018);
		CalendarDate february29 = new CalendarDate(2,29,2018);
		CalendarDate february28 = new CalendarDate(2,28,2018);
		CalendarDate december1 = new CalendarDate(12,1,2018);
		CalendarDate december31 = new CalendarDate(12,31,2018);
		
		CalendarDate february29Correct = new CalendarDate(2,29,2016);
		CalendarDate leap100 = new CalendarDate(2,29,1900);
		CalendarDate leap400 = new CalendarDate(2,29,400);
		
		
		
		System.out.println(defaultDate.toString() + "prev date" + defaultDate.prevDate());
		System.out.println(today.toString() + " day of week:" + today.dayOfWeek());
		System.out.println(january31.toString() + "next date" + january31.nextDate());
		System.out.println(february28.toString() + "next date" + february28.nextDate());
		System.out.println(february29.toString());
		System.out.println(december1.toString() + "prev date" + december1.prevDate());
		System.out.println(december31.toString() + "next date" + december31.nextDate());
		System.out.println(february29Correct.toString() + " day of week:" + february29Correct.dayOfWeek());
		System.out.println(leap100.toString() + " day of week:" + leap100.dayOfWeek());
		System.out.println(leap400.toString() + " day of week:" + leap400.dayOfWeek());
	}

}