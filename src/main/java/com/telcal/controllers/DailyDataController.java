package com.telcal.controllers;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telcal.data.UserData;
import com.telcal.entity.Amrutham;
import com.telcal.entity.DailyDataView;
import com.telcal.entity.Durmuhurtham;
import com.telcal.entity.Ocassions;
import com.telcal.entity.Varjyam;
import com.telcal.repositories.AmruthamRepo;
import com.telcal.repositories.DailyDataRepo;
import com.telcal.repositories.DailyDataViewRepo;
import com.telcal.repositories.DurmuhurthamRepo;
import com.telcal.repositories.OcassionsRepo;
import com.telcal.repositories.VarjyamRepo;
import com.telcal.transformers.DailyDataTransformer;

import jakarta.servlet.http.HttpServletRequest;
import util.DateTimeUtils;

@RestController
@CrossOrigin
public class DailyDataController {

	@Autowired
	DailyDataRepo repo;

	@Autowired
	DailyDataViewRepo dailyDataViewRepo;

	@Autowired
	AmruthamRepo amruthamRepo;

	@Autowired
	VarjyamRepo varjyamRepo;

	@Autowired
	OcassionsRepo ocassionsRepo;

	@Autowired
	DurmuhurthamRepo durmuhurthamRepo;

	@Autowired
	DailyDataTransformer transformer;

	@PostMapping("/getTransoformedDataByDate")
	@CrossOrigin(originPatterns = { "*://*/*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.DELETE }, allowedHeaders = { "Content-Type", "Accept", "X-Requested-With",
					"Authorization" }, exposedHeaders = { "Location", "Content-Disposition", "Content-Type", "Accept",
							"Authorization" }, maxAge = 3600, allowCredentials = "true")

	public ResponseEntity<List<DailyDataView>> getTransformedDataByDate(@RequestHeader("x-lang") String lang,
			@RequestBody UserData user, HttpServletRequest httpRequest) throws Exception {
		String date = user.getDate();
		int desantharakalam = user.getDesantharakalam();

		System.out.println("Get Data By Date : " + date);
		System.out.println("Get Data By Desantharakalam : " + desantharakalam);

		String origin = "*";

		if (!httpRequest.getHeader("Access-Control-Allow-Origin").isEmpty())
			origin = httpRequest.getHeader("Access-Control-Allow-Origin").toString();

		System.out.println("origin being passed as  " + origin);

		List<DailyDataView> repoResult = dailyDataViewRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		List<Amrutham> amruthamData = amruthamRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		List<Varjyam> varjyamData = varjyamRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		List<Durmuhurtham> durmuhurthamData = durmuhurthamRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		List<Ocassions> ocassionsData = ocassionsRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		if (repoResult.size() == 0) {
			List<DailyDataView> respList = new ArrayList<>();
			DailyDataView resp = new DailyDataView();
			resp.setDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));
			resp.setError("No Data Found");
			respList.add(resp);
			return ResponseEntity.ok().headers(getCorHeaders(origin)).body(respList);
		} else {

//			adjustResultsToDesantharaKaalam(repoResult);

			repoResult.forEach(k -> {
				k.setError("");

				k.setAmruthamListEn(
						amruthamData.stream().map(item -> item.getTimingsAsStringByDesantharakalamEn(desantharakalam))
								.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
									if (list.isEmpty())
										list.add("Not Applicable");
									return list;
								})));
				k.setAmruthamListTe(
						amruthamData.stream().map(item -> item.getTimingsAsStringByDesantharakalamTe(desantharakalam))
								.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
									if (list.isEmpty())
										list.add("లేదు");
									return list;
								})));

				k.setVarjyamListEn(
						varjyamData.stream().map(item -> item.getTimingsAsStringByDesantharakalamEn(desantharakalam))
								.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
									if (list.isEmpty())
										list.add("Not Applicable");
									return list;
								})));
				k.setVarjyamListTe(
						varjyamData.stream().map(item -> item.getTimingsAsStringByDesantharakalamTe(desantharakalam))
								.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
									if (list.isEmpty())
										list.add("లేదు");
									return list;
								})));

				k.setDurmuhurthamListEn(durmuhurthamData.stream()
						.map(item -> item.getTimingsAsStringByDesantharakalamEn(desantharakalam))
						.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
							if (list.isEmpty())
								list.add("Not Applicable");
							return list;
						})));
				k.setDurmuhurthamListTe(durmuhurthamData.stream()
						.map(item -> item.getTimingsAsStringByDesantharakalamTe(desantharakalam))
						.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
							if (list.isEmpty())
								list.add("లేదు");
							return list;
						})));

				k.setOccasionEn(ocassionsData.stream().map(item -> item.getOcassion_en()).toList());
				k.setOccasionTe(ocassionsData.stream().map(item -> item.getOcassion_te()).toList());

			});

			repoResult = adjustResultstoDesantharakalam(repoResult, desantharakalam);

			return ResponseEntity.ok().headers(getCorHeaders(origin)).body(repoResult);
		}
	}

	private List<DailyDataView> adjustResultstoDesantharakalam(List<DailyDataView> repoResult, int desantharakalam) {
		for (DailyDataView data : repoResult) {

			if (!(data.getThidhi_from().isBlank() && data.getThidhi_from().isEmpty()))
				data.setThidhi_from(
						LocalDateTime.parse(data.getThidhi_from(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
								.plusMinutes(desantharakalam));

			if (!(data.getThidhi_to().isBlank() && data.getThidhi_to().isEmpty()))
				data.setThidhi_to(
						LocalDateTime.parse(data.getThidhi_to(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
								.plusMinutes(desantharakalam));

			if (!(data.getNakshatram_from().isBlank() && data.getNakshatram_from().isEmpty()))
				data.setNakshatram_from(LocalDateTime
						.parse(data.getNakshatram_from(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
						.plusMinutes(desantharakalam));

			if (!(data.getNakshatram_to().isBlank() && data.getNakshatram_to().isEmpty()))
				data.setNakshatram_to(
						LocalDateTime.parse(data.getNakshatram_to(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
								.plusMinutes(desantharakalam));

			data.setSunrise(DateTimeUtils.convertTimeToHHMM(DateTimeUtils
					.convertLocalTimeToString(LocalTime.parse(data.getSunrise()).plusMinutes(desantharakalam))));
			data.setSunset(DateTimeUtils.convertTimeToHHMM(DateTimeUtils
					.convertLocalTimeToString(LocalTime.parse(data.getSunset()).plusMinutes(desantharakalam))));

		}

		return repoResult;
	}

	public HttpHeaders getCorHeaders(String origin) {
		HttpHeaders headers = new HttpHeaders();

		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Authorization");
		headers.add("Access-Control-Expose-Headers",
				"Location, Content-Disposition, Content-Type, Accept, Authorization");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Allow-Credentials", "true");

		headers.add("Access-Control-Allow-Origin", origin);
		return headers;

	}

}
