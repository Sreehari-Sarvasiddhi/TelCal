package com.telcal.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telcal.entity.Day;
import com.telcal.repositories.DayRepo;

@RestController
public class DayController {

	@Autowired
	DayRepo repo;

	private List<Day> allObjectsList;

	@GetMapping("/allDays")
	public ResponseEntity<List<Day>> getAllDayList() {
		if (allObjectsList == null || allObjectsList.isEmpty()) {
			List<Day> entryList = repo.findAll();
			entryList.sort(Comparator.comparingLong(Day::getId));
			allObjectsList = entryList;

			return ResponseEntity.ok().body(entryList);
		} else {
			return ResponseEntity.ok(allObjectsList);
		}
	}

	@GetMapping("/dayById/{id}")
	public ResponseEntity<Day> getDayById(@PathVariable Long id) {
		return repo.findById(id).map(n -> ResponseEntity.ok().body(n))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/deleteDay/{id}")
	public ResponseEntity<List<Day>> deleteDay(@PathVariable Long id) {

		try {
			if (repo.existsById(id)) {
				repo.deleteById(id);
				return ResponseEntity.ok().body(repo.findAll());
			}
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(repo.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

		return ResponseEntity.internalServerError().body(null);
	}

	@PostMapping("/addDay")
	public ResponseEntity<Day> addDay(@RequestBody Day Day) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(Day));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/refreshDayList")
	public ResponseEntity<Boolean> refreshAllDayList() {
		List<Day> entryList = repo.findAll();
		entryList.sort(Comparator.comparingLong(Day::getId));

		allObjectsList = entryList;
		return ResponseEntity.ok(true);

	}

	public Map<Long, Day> getAsMap() {
		return (Map<Long, Day>) this.allObjectsList.stream().collect(Collectors.toMap(Day::getId, k  -> k));
	}

}
