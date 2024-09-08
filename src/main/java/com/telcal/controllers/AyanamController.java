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

import com.telcal.entity.Ayanam;
import com.telcal.repositories.AyanamRepo;

@RestController
public class AyanamController {

	@Autowired
	AyanamRepo repo;

	private List<Ayanam> allObjectsList;

	@GetMapping("/allAyanams")
	public ResponseEntity<List<Ayanam>> getAllAyanamList() {
		if (allObjectsList == null || allObjectsList.isEmpty()) {
			List<Ayanam> entryList = repo.findAll();
			entryList.sort(Comparator.comparingLong(Ayanam::getId));

			allObjectsList = entryList;
			return ResponseEntity.ok().body(entryList);
		} else {
			return ResponseEntity.ok(allObjectsList);
		}
	}

	@GetMapping("/ayanamById/{id}")
	public ResponseEntity<Ayanam> getAyanamById(@PathVariable Long id) {
		return repo.findById(id).map(n -> ResponseEntity.ok().body(n))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/deleteAyanam/{id}")
	public ResponseEntity<List<Ayanam>> deleteAyanam(@PathVariable Long id) {

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

	@PostMapping("/addAyanam")
	public ResponseEntity<Ayanam> addAyanam(@RequestBody Ayanam Ayanam) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(Ayanam));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/refreshAyanamList")
	public ResponseEntity<Boolean> refreshAllAyanamList() {
		List<Ayanam> entryList = repo.findAll();
		entryList.sort(Comparator.comparingLong(Ayanam::getId));

		allObjectsList = entryList;
		return ResponseEntity.ok(true);

	}

	public Map<Long, Ayanam> getAsMap() {
		return (Map<Long, Ayanam>) this.allObjectsList.stream().collect(Collectors.toMap(Ayanam::getId, k  -> k));
	}
}
