package com.telcal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<List<DailyDataResponseType>> getAllDailyDataList() {
		List<DailyData> entryList = repo.findAll();

//		entryList.sort(Comparator.comparing(DailyData::getDate));

		List<DailyDataResponseType> response = new ArrayList<>();
		entryList.forEach(k -> response.add(transformer.transformResponse(k)));

		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/insertDailyData")
	public ResponseEntity<DailyData> insertDailyData(DailyData data) {

		return ResponseEntity.ok(data);

	}

}
