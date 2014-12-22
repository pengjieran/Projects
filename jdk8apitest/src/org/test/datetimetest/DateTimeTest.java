package org.test.datetimetest;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class DateTimeTest {

	public static void main(String[] args) {
		
		dateTest();
		
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
}