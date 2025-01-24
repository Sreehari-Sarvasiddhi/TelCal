package com.telcal.transformers;

import java.time.LocalDateTime;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Component;

import com.telcal.entity.DailyDataView;
import com.telcal.entity.Month;
import com.telcal.repositories.MonthRepo;
import com.telcal.util.DateTimeUtils;

@Component
public class DateStringConverter {

	public String convertToOrdinalString(MonthRepo monthRepo, DailyDataView dailyDataView, LocalDateTime dateTime,
			boolean isEn) {
		if (dateTime != null) {
			// Custom formatter for time
//			DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

			String formattedDate = getOrdinalFormattedDateString(dateTime, isEn, monthRepo, true);

			String prefix = "Upto";

			String suffix = "వరకు";

			if (isEn)
				return WordUtils.capitalizeFully(prefix + " " + formattedDate);
			else
				return WordUtils.capitalizeFully(formattedDate + " " + suffix);
		} else {
			return "";
		}
	}

	public String getOrdinalFormattedDateString(LocalDateTime dateTime, boolean isEn, MonthRepo monthRepo,
			boolean isDateIncl) {
		String dayWithSuffix = "";
		// Get the day with ordinal suffix (e.g., 26th)
		if (isEn)
			dayWithSuffix = getDayWithSuffix(dateTime.getDayOfMonth());
		else
			dayWithSuffix = String.valueOf(dateTime.getDayOfMonth());

		Month monthEntity = monthRepo.findById(Long.valueOf(dateTime.getMonthValue())).get();

		String month = "";
		// Get abbreviated month name
		if (isEn)
			month = monthEntity.getName();
		else
			month = monthEntity.getPeru(); // dailyDataView.getMonth_peru();

		// Combine the parts
		String formattedDate = "";

		if (isDateIncl) {
			formattedDate = String.format("%s %s, %s", month, dayWithSuffix,
					DateTimeUtils.convertLocalDateTimeToLocalTimeString(dateTime));
		} else {
			formattedDate = DateTimeUtils.convertLocalDateTimeToLocalTimeString(dateTime);
		}

		return formattedDate;
	}

	private String getDayWithSuffix(int day) {
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
