package util;

import java.time.LocalDate;
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

}
