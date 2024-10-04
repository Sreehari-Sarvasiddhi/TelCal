package com.telcal.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.telcal.data.DailyDataResponseType;
import com.telcal.entity.DailyData;
import com.telcal.repositories.DailyDataRepo;
import com.telcal.transformers.DailyDataTransformer;

@RestController
public class DailyDataController {

	@Autowired
	DailyDataRepo repo;

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
	public ResponseEntity<DailyDataResponseType> getdataByDate(@RequestHeader("x-lang") String lang,
			@RequestBody String date) throws Exception {
		System.out.printf("Get Data By Date : {}", date);

		List<DailyDataResponseType> response = getAllObjectsList(lang).stream()
				.filter(k -> date.equals(convertDateToString(k.getDate()))).toList();

		return ResponseEntity.ok(response.get(0));
	}

	private String convertDateToString(LocalDate localDate) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return localDate.format(formatter);

	}

	private List<DailyDataResponseType> getAllObjectsList(String lang) throws Exception {
		return getAllDailyDataList(lang).getBody();
	}

}
