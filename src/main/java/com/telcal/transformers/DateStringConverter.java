package com.telcal.transformers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import com.telcal.entity.DailyDataView;

public class DateStringConverter {
	public static String convertToOrdinalString(DailyDataView dailyDataView, LocalDateTime dateTime, boolean isEn) {
		if (dateTime != null) {
			// Custom formatter for time
			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

			String dayWithSuffix = "";
			// Get the day with ordinal suffix (e.g., 26th)
			if (isEn)
				dayWithSuffix = getDayWithSuffix(dateTime.getDayOfMonth());
			else
				dayWithSuffix = String.valueOf(dateTime.getDayOfMonth());

			String month = "";
			// Get abbreviated month name
			if (isEn)
				month = dateTime.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
			else
				month = dailyDataView.getMonth_peru();

			// Combine the parts
			String formattedDate = String.format("%s %s, %s", month, dayWithSuffix, dateTime.format(timeFormatter));

			String prefix = "Upto";

			String suffix = "వరకు";

			if (isEn)
				return prefix + " " + formattedDate;
			else
				return formattedDate + " " + suffix;
		} else {
			return "";
		}
	}

	private static String getDayWithSuffix(int day) {
		if (day >= 11 && day <= 13)
			return day + "th";
		switch (day % 10) {
		case 1:
			return day + "st";
		case 2:
			return day + "nd";
		case 3:
			return day + "rd";
		default:
			return day + "th";
		}
	}
}
