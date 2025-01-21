package com.telcal.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

	public static String convertTimeToHHMM(String time) {
		// Parse the time using LocalTime
		LocalTime parsedTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));

		// Format it to hh:mm
		String formattedTime = parsedTime.format(DateTimeFormatter.ofPattern("HH:mm"));

		return formattedTime;
	}

	public static String convertLocalTimeToString(LocalTime time) {
		// Parse the time using LocalTime

		// Format it to hh:mm:ss
		String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

		return formattedTime;
	}

	public static String convertLocalDateTimeToLocalTimeString(LocalDateTime time) {
		// Parse the time using LocalTime

		// Format it to hh:mm:ss
		String formattedTime = time.format(DateTimeFormatter.ofPattern("HH:mm"));

		return formattedTime;
	}

	public static String convertLocalDateTimeToString(LocalDateTime time) {
		// Parse the time using LocalTime

		// Format it to hh:mm:ss
		String formattedTime = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		return formattedTime;
	}

	public static LocalDate convertStringtoLocalDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate localDate = LocalDate.parse(dateString, formatter);
		return localDate;
	}

	public static String convertDateStringFormat(String dateString) {

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		LocalDate date = LocalDate.parse(dateString, inputFormatter);
		String formattedDate = date.format(outputFormatter);

		System.out.println(formattedDate);

		return formattedDate;
	}

	public static String getMonthFromDate(String datestr) {
		// Parse the input date string to a LocalDate
		LocalDate date = LocalDate.parse(datestr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		// Get the month number (1 = January, 12 = December)
		String monthNumber = String.format("%02d", date.getMonthValue());
		return monthNumber;

	}

}
