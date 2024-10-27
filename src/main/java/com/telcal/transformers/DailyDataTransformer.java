package com.telcal.transformers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telcal.controllers.AyanamController;
import com.telcal.controllers.DayController;
import com.telcal.controllers.MaasamController;
import com.telcal.controllers.MonthController;
import com.telcal.controllers.NakshatramController;
import com.telcal.controllers.PakshamController;
import com.telcal.controllers.RuthuvuController;
import com.telcal.controllers.SamvathsaramController;
import com.telcal.controllers.ThithiController;
import com.telcal.data.DailyDataResponseType;
import com.telcal.entity.DailyData;

@Component
public class DailyDataTransformer {

	@Autowired
	SamvathsaramController samvathsaramController;

	@Autowired
	AyanamController ayanamController;

	@Autowired
	RuthuvuController ruthuvuController;

	@Autowired
	MaasamController maasamController;

	@Autowired
	PakshamController pakshamController;

	@Autowired
	ThithiController thithiController;

	@Autowired
	DayController dayController;

	@Autowired
	MonthController monthController;

	@Autowired
	NakshatramController nakshatramController;

	public DailyDataResponseType transformResponse(DailyData dailyData, String language) {

		DailyDataResponseType response = new DailyDataResponseType();

		if (dailyData != null && dailyData.getId() != null) {
			response.setId(dailyData.getId());
			response.setDate(convertLocalDateToString(dailyData.getDate()));

			if ("TE".equalsIgnoreCase(language)) {
				response.setSamvathsaram(
						samvathsaramController.getAsMap().get(dailyData.getT_samvathsaram_id()).getPeru());
				response.setAyanam(ayanamController.getAsMap().get(dailyData.getT_ayanam_id()).getPeru());
				response.setRuthuvu(ruthuvuController.getAsMap().get(dailyData.getT_ruthuvu_id()).getPeru());
				response.setMaasam(maasamController.getAsMap().get(dailyData.getT_maasam_id()).getPeru());
				response.setPaksham(pakshamController.getAsMap().get(dailyData.getT_paksham_id()).getPeru());
				response.setThidhi(thithiController.getAsMap().get(dailyData.getT_thidhi_id()).getPeru());
				response.setDay(dayController.getAsMap().get(dailyData.getE_day_id()).getPeru());
				response.setNakshatram(nakshatramController.getAsMap().get(dailyData.getT_nakshatram_id()).getPeru());
				response.setMonth(monthController.getAsMap().get(dailyData.getE_month_id()).getPeru());
			} else {
				response.setSamvathsaram(
						samvathsaramController.getAsMap().get(dailyData.getT_samvathsaram_id()).getName());
				response.setAyanam(ayanamController.getAsMap().get(dailyData.getT_ayanam_id()).getName());
				response.setRuthuvu(ruthuvuController.getAsMap().get(dailyData.getT_ruthuvu_id()).getName());
				response.setMaasam(maasamController.getAsMap().get(dailyData.getT_maasam_id()).getName());
				response.setPaksham(pakshamController.getAsMap().get(dailyData.getT_paksham_id()).getName());
				response.setThidhi(thithiController.getAsMap().get(dailyData.getT_thidhi_id()).getName());
				response.setDay(dayController.getAsMap().get(dailyData.getE_day_id()).getName());
				response.setNakshatram(nakshatramController.getAsMap().get(dailyData.getT_nakshatram_id()).getName());
				response.setMonth(monthController.getAsMap().get(dailyData.getE_month_id()).getName());

			}
			response.setNakshatram_from(convertLocalDateTimeToString(dailyData.getT_nakshatram_from()));
			response.setNakshatram_to(convertLocalDateTimeToString(dailyData.getT_nakshatram_to()));
			response.setThidhi_from(convertLocalDateTimeToString(dailyData.getT_thidhi_from()));
			response.setThidhi_to(convertLocalDateTimeToString(dailyData.getT_thidhi_to()));
			response.setSunrise(convertLocalTimeToString(dailyData.getSunrise()));
			response.setSunset(convertLocalTimeToString(dailyData.getSunset()));
			response.setOccasion(dailyData.getOccasion());
		}

		return response;
	}

	private String convertLocalDateToString(LocalDate date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = date.format(formatter);

		System.out.println(formattedDate);

		return formattedDate;

	}

	private String convertLocalDateTimeToString(LocalDateTime date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = date.format(formatter);
		System.out.println(formattedDateTime);

		return formattedDateTime;

	}

	private String convertLocalTimeToString(LocalTime time) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedTime = time.format(formatter);
		System.out.println(formattedTime);

		return formattedTime;

	}

}
