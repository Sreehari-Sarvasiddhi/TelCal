package com.telcal.util;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telcal.entity.DailyDataView;
import com.telcal.repositories.MonthRepo;
import com.telcal.transformers.DateStringConverter;

@Component
public class DailyDataOrdinalUtil {

	@Autowired
	DateStringConverter dateStringConverter;

	@Autowired
	private MonthRepo monthRepo;

	public List<DailyDataView> adjustOrdinalsForThidhiAndNakshatram(List<DailyDataView> dailyData) {

		for (DailyDataView data : dailyData) {
			data.setThidhi_from_en(dateStringConverter.convertToOrdinalString(monthRepo, data, data.thidhi_from, true));
			data.setThidhi_to_en(dateStringConverter.convertToOrdinalString(monthRepo, data, data.thidhi_to, true));
			data.setThidhi_from_te(
					dateStringConverter.convertToOrdinalString(monthRepo, data, data.thidhi_from, false));
			data.setThidhi_to_te(dateStringConverter.convertToOrdinalString(monthRepo, data, data.thidhi_to, false));

			data.setNakshatram_from_en(
					dateStringConverter.convertToOrdinalString(monthRepo, data, data.nakshatram_from, true));
			data.setNakshatram_to_en(
					dateStringConverter.convertToOrdinalString(monthRepo, data, data.nakshatram_to, true));
			data.setNakshatram_from_te(
					dateStringConverter.convertToOrdinalString(monthRepo, data, data.nakshatram_from, false));
			data.setNakshatram_to_te(
					dateStringConverter.convertToOrdinalString(monthRepo, data, data.nakshatram_to, false));
		}

		return dailyData;
	}

	public String adjustOrdinalsForAmrutham(LocalDateTime from_time, LocalDateTime to_time, boolean isEn) {

		String from = dateStringConverter.getOrdinalFormattedDateString(from_time, isEn, monthRepo, true);

		String to = "";
		if (from_time.toLocalDate().equals(to_time.toLocalDate()))
			to = dateStringConverter.getOrdinalFormattedDateString(to_time, isEn, monthRepo, false);
		else
			to = dateStringConverter.getOrdinalFormattedDateString(to_time, isEn, monthRepo, true);

		System.out.println("test ordinal data :::");
		System.out.println(from);
		System.out.println(to);

		String result = isEn ? "From " + from + " to " + to : from + " నుండి " + to + " వరకు";

		return result;

	}

}
