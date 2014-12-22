package org.test.datetimetest;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeTest {

	public static void main(String[] args) {
		
		dateTest();
		timeTest();
		localDateTimeTest();
		instantTest();
		dateTimeUtils();
		dateParseFormatTest();
		dateAPILegacySupport();
	}
	
	private static void dateTest() {
		
		LocalDate today = LocalDate.now();
		System.out.println("当前日期：" + today);
		
		LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
		System.out.println("2014年第一天：" + firstDay_2014);
		
		LocalDate todayAsia = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("亚洲时区的当前日期：" + todayAsia);
		
		LocalDate ofEpochDay = LocalDate.ofEpochDay(365);
		System.out.println("基准日期点" + ofEpochDay);
		
		LocalDate ofYearDay = LocalDate.ofYearDay(2014, 100);
		System.out.println("2014年第100天的日期" + ofYearDay);
	}
	
	private static void timeTest() {
		
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		LocalTime setTime = LocalTime.of(23, 25, 45, 20);
		System.out.println(setTime);
		
		LocalTime timeOfAsia = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(timeOfAsia);
		
		LocalTime ofSecondOfDay = LocalTime.ofSecondOfDay(10000);
		System.out.println(ofSecondOfDay);
	}
	
	private static void localDateTimeTest() {
		
		//Current Date
		LocalDateTime today = LocalDateTime.now();
		System.out.println("Current DateTime="+today);
		//Current Date using LocalDate and LocalTime
		today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current DateTime="+today);
		//Creating LocalDateTime by providing input arguments
		LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
		System.out.println("Specific Date="+specificDate);
		//Try creating date by providing invalid inputs
		//LocalDateTime feb29_2014 = LocalDateTime.of(2014, Month.FEBRUARY, 28, 25,1,1);
		//Exception in thread "main" java.time.DateTimeException: 
		//Invalid value for HourOfDay (valid values 0 - 23): 25
		//Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Date in IST="+todayKolkata);
		//java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
		//LocalDateTime todayIST = LocalDateTime.now(ZoneId.of("IST"));
		//Getting date from the base date i.e 01/01/1970
		LocalDateTime dateFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
		System.out.println("10000th second time from 01/01/1970= "+dateFromBase);
	}
	
	private static void instantTest() {
		
		Instant instant = Instant.now();
		System.out.println(instant);
		
		Instant ofEpochMilli = Instant.ofEpochMilli(instant.toEpochMilli());
		System.out.println(ofEpochMilli);
		
		Duration duration = Duration.ofDays(30);
		System.out.println(duration);
		
	}
	
	private static void dateTimeUtils() {
		
		LocalDate today = LocalDate.now();
		//Get the Year, check if it's leap year
		System.out.println("Year "+today.getYear()+" is Leap Year? "+today.isLeapYear());
		//Compare two LocalDate for before and after
		System.out.println("Today is before 01/01/2015? "+today.isBefore(LocalDate.of(2015,1,1)));
		//Create LocalDateTime from LocalDate
		System.out.println("Current Time="+today.atTime(LocalTime.now()));
		//plus and minus operations
		System.out.println("10 days after today will be "+today.plusDays(10));
		System.out.println("3 weeks after today will be "+today.plusWeeks(3));
		System.out.println("20 months after today will be "+today.plusMonths(20));
		System.out.println("10 days before today will be "+today.minusDays(10));
		System.out.println("3 weeks before today will be "+today.minusWeeks(3));
		System.out.println("20 months before today will be "+today.minusMonths(20));
		//Temporal adjusters for adjusting the dates
		System.out.println("First date of this month= "+today.with(TemporalAdjusters.firstDayOfMonth()));
		LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("Last date of this year= "+lastDayOfYear);
		Period period = today.until(lastDayOfYear);
		System.out.println("Period Format= "+period);
		System.out.println("Months remaining in the year= "+period.getMonths());
	}
	
	private static void dateParseFormatTest() {
		
		LocalDate today = LocalDate.now();
		System.out.println("today:" + today);
		System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
		System.out.println(today.format(DateTimeFormatter.BASIC_ISO_DATE));
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println("now:" + now);
		System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:SS")));
		System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));
		
		Instant timestamp = Instant.now();
		//default format
		System.out.println("Default format of Instant="+timestamp);
		//Parse examples,这部分有问题
		//LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
		//DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
		//System.out.println("Default format after parsing = "+dt);
	}
	
	private static void dateAPILegacySupport() {
		
		//Date to Instant
		Instant timestamp = new Date().toInstant();
		//Now we can convert Instant to LocalDateTime or other similar classes
		LocalDateTime date = LocalDateTime.ofInstant(timestamp, 
		      ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
		System.out.println("Date = "+date);
		//Calendar to Instant
		Instant time = Calendar.getInstance().toInstant();
		System.out.println(time);
		//TimeZone to ZoneId
		ZoneId defaultZone = TimeZone.getDefault().toZoneId();
		System.out.println(defaultZone);
		//ZonedDateTime from specific Calendar
		ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
		System.out.println(gregorianCalendarDateTime);
		//Date API to Legacy classes
		Date dt = Date.from(Instant.now());
		System.out.println(dt);
		TimeZone tz = TimeZone.getTimeZone(defaultZone);
		System.out.println(tz);
		GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
		System.out.println(gc);
	}
}