package com.telcal.transformers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateToStringConverter {

	public static String convertLocalDatetoString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return (date != null) ? date.format(formatter) : "";
	}

	public static String convertLocalDateTimetoString(LocalDateTime dateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return (dateTime != null) ? dateTime.format(formatter) : "";
	}

}
