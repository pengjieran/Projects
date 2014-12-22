package org.test.datetimetest;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class DateTimeTest {

	public static void main(String[] args) {
		
		//dateTest();
		//timeTest();
		//localDateTimeTest();
		instantTest();
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
}