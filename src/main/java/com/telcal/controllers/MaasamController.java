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

import com.telcal.entity.Maasam;
import com.telcal.repositories.MaasamRepo;

@RestController
public class MaasamController {

	@Autowired
	MaasamRepo repo;

	private List<Maasam> allObjectsList;

	@GetMapping("/allMaasams")
	public ResponseEntity<List<Maasam>> getAllMaasamList() {
		if (allObjectsList == null || allObjectsList.isEmpty()) {
			List<Maasam> entryList = repo.findAll();
			entryList.sort(Comparator.comparingLong(Maasam::getId));
			allObjectsList = entryList;

			return ResponseEntity.ok().body(entryList);
		} else {
			return ResponseEntity.ok(allObjectsList);
		}
	}

	@GetMapping("/maasamById/{id}")
	public ResponseEntity<Maasam> getMaasamById(@PathVariable Long id) {
		return repo.findById(id).map(n -> ResponseEntity.ok().body(n))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/deleteMaasam/{id}")
	public ResponseEntity<List<Maasam>> deleteMaasam(@PathVariable Long id) {

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

	@PostMapping("/addMaasam")
	public ResponseEntity<Maasam> addMaasam(@RequestBody Maasam Maasam) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(Maasam));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/refreshMaasamList")
	public ResponseEntity<Boolean> refreshAllDayList() {
		List<Maasam> entryList = repo.findAll();
		entryList.sort(Comparator.comparingLong(Maasam::getId));

		allObjectsList = entryList;
		return ResponseEntity.ok(true);

	}

	public Map<Long, Maasam> getAsMap() {
		return (Map<Long, Maasam>) this.allObjectsList.stream().collect(Collectors.toMap(Maasam::getId, k  -> k));
	}
}
