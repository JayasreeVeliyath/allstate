/**
 * 
 */
package com.allstate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author jayasreeveliyath
 *
 */
public class DateTimeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDate today = LocalDate.of(2022, 10, 25);

		String indianDatePattern = "dd-MM-YYYY";
		DateTimeFormatter indianDateFormatter = DateTimeFormatter.ofPattern(indianDatePattern);
		System.out.println("Date in Indian pattern: " +indianDateFormatter.format(today));
		
		System.out.println("Date in Full style: " +DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(today));
		System.out.println("Date in Long style: " +DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(today));
		System.out.println("Date in Medium style: " +DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(today));
		System.out.println("Date in Short style: " +DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(today));
		
		String timeDotPattern = "HH.mm.ss";
		DateTimeFormatter timeDotFormatter = DateTimeFormatter.ofPattern(timeDotPattern);
		LocalTime localTime = LocalTime.of(13, 30, 01);
		System.out.println("Time in pipe style: " +timeDotFormatter.format(localTime));
	}
}