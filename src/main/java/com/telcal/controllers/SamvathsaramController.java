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

import com.telcal.entity.Samvathsaram;
import com.telcal.repositories.SamvathsaramRepo;

@RestController
public class SamvathsaramController {

	@Autowired
	SamvathsaramRepo repo;

	private List<Samvathsaram> allObjectsList;

	@GetMapping("/allSamvathsarams")
	public ResponseEntity<List<Samvathsaram>> getAllSamvathsaramList() {
		if (allObjectsList == null || allObjectsList.isEmpty()) {
			List<Samvathsaram> entryList = repo.findAll();
			entryList.sort(Comparator.comparingLong(Samvathsaram::getId));
			allObjectsList = entryList;

			return ResponseEntity.ok().body(entryList);
		} else {
			return ResponseEntity.ok(allObjectsList);
		}
	}

	@GetMapping("/samvathsaramById/{id}")
	public ResponseEntity<Samvathsaram> getSamvathsaramById(@PathVariable Long id) {
		return repo.findById(id).map(n -> ResponseEntity.ok().body(n))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/deleteSamvathsaram/{id}")
	public ResponseEntity<List<Samvathsaram>> deleteSamvathsaram(@PathVariable Long id) {

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

	@PostMapping("/addSamvathsaram")
	public ResponseEntity<Samvathsaram> addSamvathsaram(@RequestBody Samvathsaram Samvathsaram) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(Samvathsaram));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/refreshSamvathsaramList")
	public ResponseEntity<Boolean> refreshAllSamvathsaramList() {
		List<Samvathsaram> entryList = repo.findAll();
		entryList.sort(Comparator.comparingLong(Samvathsaram::getId));

		allObjectsList = entryList;
		return ResponseEntity.ok(true);

	}

	public Map<Long, Samvathsaram> getAsMap() {
		return (Map<Long, Samvathsaram>) this.allObjectsList.stream()
				.collect(Collectors.toMap(Samvathsaram::getId, k -> k));
	}

}
