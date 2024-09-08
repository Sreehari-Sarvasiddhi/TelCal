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

import com.telcal.entity.Thithi;
import com.telcal.repositories.ThithiRepo;

@RestController
public class ThithiController {

	@Autowired
	ThithiRepo repo;

	private List<Thithi> allObjectsList;

	@GetMapping("/allThithis")
	public ResponseEntity<List<Thithi>> getAllThithiList() {
		if (allObjectsList == null || allObjectsList.isEmpty()) {
			List<Thithi> entryList = repo.findAll();
			entryList.sort(Comparator.comparingLong(Thithi::getId));
			allObjectsList = entryList;

			return ResponseEntity.ok().body(entryList);
		} else {
			return ResponseEntity.ok(allObjectsList);
		}
	}

	@GetMapping("/thithiById/{id}")
	public ResponseEntity<Thithi> getThithiById(@PathVariable Long id) {
		return repo.findById(id).map(n -> ResponseEntity.ok().body(n))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/deleteThithi/{id}")
	public ResponseEntity<List<Thithi>> deleteThithi(@PathVariable Long id) {

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

	@PostMapping("/addThithi")
	public ResponseEntity<Thithi> addThithi(@RequestBody Thithi Thithi) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(Thithi));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/refreshThithiList")
	public ResponseEntity<Boolean> refreshAllThithiList() {
		List<Thithi> entryList = repo.findAll();
		entryList.sort(Comparator.comparingLong(Thithi::getId));

		allObjectsList = entryList;
		return ResponseEntity.ok(true);

	}

	public Map<Long, Thithi> getAsMap() {
		return (Map<Long, Thithi>) this.allObjectsList.stream().collect(Collectors.toMap(Thithi::getId, k -> k));
	}

}
