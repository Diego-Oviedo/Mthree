package com.diego.practices;

import java.time.*;
import java.time.format.*;

public class DateTimeAPIPractice {

	public static void main(String[] args) {
		LocalDate date_now = LocalDate.now();
		
		System.out.println("Date now: " + date_now);
		
		LocalDate date_custom = LocalDate.parse("12/25/2010", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		
		System.out.println("Date custom: " + date_custom);

		LocalDate date_past = LocalDate.now();
		date_past = date_past.minusDays(8);
		
		System.out.println("Date past: " + date_past);
		
		LocalDate date_future = LocalDate.now();
		date_future = date_future.plusDays(8);
		
		System.out.println("Date future: " + date_future);
		
		Period difference = date_past.until(date_future);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String date_past_formatted = date_past.format(
			    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
		
		int difference_formatted = difference.getDays();
		
		System.out.println("The difference between " + date_past_formatted + " and " + date_future + " is: " + difference_formatted + " days");
	}

}
