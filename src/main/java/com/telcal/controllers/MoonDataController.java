package com.telcal.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telcal.data.MoonDataRequest;
import com.telcal.entity.DailyData;
import com.telcal.repositories.DailyDataRepo;
import com.telcal.transformers.LocalDateToStringConverter;
import com.telcal.util.DateTimeUtils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MoonDataController {

	@Autowired
	DailyDataRepo dailyDataRepo;

	@Autowired
	DailyDataController dailyDataController;

	@PostMapping("/getMoonDataByDateRange")
	@CrossOrigin(originPatterns = { "*://*/*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.DELETE }, allowedHeaders = { "Content-Type", "Accept", "X-Requested-With",
					"Authorization" }, exposedHeaders = { "Location", "Content-Disposition", "Content-Type", "Accept",
							"Authorization" }, maxAge = 3600, allowCredentials = "true")
	public ResponseEntity<Map<String, List<Long>>> getMoonDataByDateRange(@RequestBody MoonDataRequest req,
			HttpServletRequest httpRequest) {
		Map<String, List<Long>> moonData = new HashMap<>();

		String origin = "*";
		if (!httpRequest.getHeader("Access-Control-Allow-Origin").isEmpty())
			origin = httpRequest.getHeader("Access-Control-Allow-Origin").toString();

		List<DailyData> dailyData = dailyDataRepo.getDataByDateRange(
				DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(req.getStartDate())),
				DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(req.getEndDate())));

		for (DailyData data : dailyData) {
			String date = LocalDateToStringConverter.convertLocalDatetoString(data.getDate());
			if (!moonData.containsKey(date)) {
				moonData.put(date, new ArrayList<>(Arrays.asList(data.getT_thidhi_id())));
			} else if (!moonData.get(date).contains(data.getT_thidhi_id())) {
				moonData.get(date).add(data.getT_thidhi_id());
			}
		}

		return ResponseEntity.ok().headers(dailyDataController.getCorHeaders(origin)).body(sortMapByDateKey(moonData));

	}

	public static Map<String, List<Long>> sortMapByDateKey(Map<String, List<Long>> map) {
		// Define the date format used in the keys
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return map.entrySet().stream().sorted((e1, e2) -> {
			try {
				Date date1 = dateFormat.parse(e1.getKey());
				Date date2 = dateFormat.parse(e2.getKey());
				return date1.compareTo(date2); // Compare the dates
			} catch (ParseException e) {
				throw new RuntimeException("Invalid date format in key", e);
			}
		}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, // Handle
																												// duplicate
																												// keys
																												// (not
																												// expected
																												// here)
				LinkedHashMap::new // Maintain the sorted order
		));
	}

}
