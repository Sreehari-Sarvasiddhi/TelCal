package com.telcal.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telcal.data.DailyDataResponseType;
import com.telcal.data.UserData;
import com.telcal.entity.DailyData;
import com.telcal.entity.DailyDataView;
import com.telcal.repositories.DailyDataRepo;
import com.telcal.repositories.DailyDataViewRepo;
import com.telcal.transformers.DailyDataTransformer;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class DailyDataController {

	@Autowired
	DailyDataRepo repo;

	@Autowired
	DailyDataViewRepo dailyDaataViewRepo;

	@Autowired
	DailyDataTransformer transformer;

	@GetMapping("/allDailyData")
	public ResponseEntity<List<DailyDataResponseType>> getAllDailyDataList(@RequestHeader("x-lang") String lang)
			throws Exception {

		if (!(lang.equalsIgnoreCase("EN") || lang.equalsIgnoreCase("TE"))) {
			throw new Exception("x-lang should be amongst EN / TE");
		}

		System.out.println("entered the dailydata endpoint");
		List<DailyDataResponseType> response = new ArrayList<>();
		List<DailyData> entryList;

		System.out.println("fetching from POSTGRES");
		entryList = repo.findAll();

		entryList.forEach(k -> response.add(transformer.transformResponse(k, lang)));

		return ResponseEntity.ok().body(response);

	}

	@PostMapping("/getDataByDate")
	@CrossOrigin(originPatterns = { "*://*/*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.DELETE }, allowedHeaders = { "Content-Type", "Accept", "X-Requested-With",
					"Authorization" }, exposedHeaders = { "Location", "Content-Disposition", "Content-Type", "Accept",
							"Authorization" }, maxAge = 3600, allowCredentials = "true")

	public ResponseEntity<List<DailyDataResponseType>> getdataByDate(@RequestHeader("x-lang") String lang,
			@RequestBody UserData user, HttpServletRequest httpRequest) throws Exception {
		String date = user.getDate();
		System.out.println("Get Data By Date : " + date);

		String origin = "*";

		if (!httpRequest.getHeader("Access-Control-Allow-Origin").isEmpty())
			origin = httpRequest.getHeader("Access-Control-Allow-Origin").toString();

		System.out.println("origin being passed as  " + origin);

		List<DailyData> repoResult = repo.findByDate(convertStringtoLocalDate(convertDateStringFormat(date)));

		List<DailyDataResponseType> response = new ArrayList<>();

		repoResult.forEach(k -> response.add(transformer.transformResponse(k, lang)));

		if (response.size() == 0) {
			List<DailyDataResponseType> respList = new ArrayList<>();
			DailyDataResponseType resp = new DailyDataResponseType();
			resp.setDate(convertDateStringFormat(date));
			resp.setError("No Data Found");
			respList.add(resp);
			return ResponseEntity.ok().headers(getCorHeaders(origin)).body(respList);
		} else {
			response.forEach(k -> k.setError(""));
			return ResponseEntity.ok().headers(getCorHeaders(origin)).body(response);
		}
	}

	private LocalDate convertStringtoLocalDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate localDate = LocalDate.parse(dateString, formatter);
		return localDate;
	}

	private String convertDateStringFormat(String dateString) {

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		LocalDate date = LocalDate.parse(dateString, inputFormatter);
		String formattedDate = date.format(outputFormatter);

		System.out.println(formattedDate);

		return formattedDate;
	}

	private List<DailyDataResponseType> getAllObjectsList(String lang) throws Exception {
		return getAllDailyDataList(lang).getBody();
	}

//	@PostMapping("/getDataForMonth/{month}/{year}")
//	public ResponseEntity<List<DailyDataResponseType>> getdataForMonth(@RequestHeader("x-lang") String lang,
//			@PathVariable int month, @PathVariable int year) {
//
//		System.out.printf("input received " + month + " - " + year + "  :: ");
//
//		List<DailyData> resp = repo.getDataForMonth(month, year);
//
//		List<DailyDataResponseType> response = new ArrayList<>();
//
//		resp.forEach(k -> response.add(transformer.transformResponse(k, lang)));
//
//		return ResponseEntity.ok(response);
//	}

	@PostMapping("/getTransoformedDataByDate")
	@CrossOrigin(originPatterns = { "*://*/*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.DELETE }, allowedHeaders = { "Content-Type", "Accept", "X-Requested-With",
					"Authorization" }, exposedHeaders = { "Location", "Content-Disposition", "Content-Type", "Accept",
							"Authorization" }, maxAge = 3600, allowCredentials = "true")

	public ResponseEntity<List<DailyDataView>> getTransformedDataByDate(@RequestHeader("x-lang") String lang,
			@RequestBody UserData user, HttpServletRequest httpRequest) throws Exception {
		String date = user.getDate();
		System.out.println("Get Data By Date : " + date);

		String origin = "*";

		if (!httpRequest.getHeader("Access-Control-Allow-Origin").isEmpty())
			origin = httpRequest.getHeader("Access-Control-Allow-Origin").toString();

		System.out.println("origin being passed as  " + origin);

		List<DailyDataView> repoResult = dailyDaataViewRepo
				.findByDate(convertStringtoLocalDate(convertDateStringFormat(date)));

//		List<DailyDataResponseType> response = new ArrayList<>();
//
//		repoResult.forEach(k -> response.add(transformer.transformResponse(k, lang)));

		if (repoResult.size() == 0) {
			List<DailyDataView> respList = new ArrayList<>();
			DailyDataView resp = new DailyDataView();
			resp.setDate(convertStringtoLocalDate(convertDateStringFormat(date)));
			resp.setError("No Data Found");
			respList.add(resp);
			return ResponseEntity.ok().headers(getCorHeaders(origin)).body(respList);
		} else {
			repoResult.forEach(k -> k.setError(""));
			return ResponseEntity.ok().headers(getCorHeaders(origin)).body(repoResult);
		}
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
