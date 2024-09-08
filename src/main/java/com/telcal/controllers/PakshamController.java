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

import com.telcal.entity.Paksham;
import com.telcal.repositories.PakshamRepo;

@RestController
public class PakshamController {

	@Autowired
	PakshamRepo repo;

	private List<Paksham> allObjectsList;

	@GetMapping("/allPakshams")
	public ResponseEntity<List<Paksham>> getAllPakshamList() {
		if (allObjectsList == null || allObjectsList.isEmpty()) {
			List<Paksham> entryList = repo.findAll();
			entryList.sort(Comparator.comparingLong(Paksham::getId));
			allObjectsList = entryList;

			return ResponseEntity.ok().body(entryList);
		} else {
			return ResponseEntity.ok(allObjectsList);
		}
	}

	@GetMapping("/pakshamById/{id}")
	public ResponseEntity<Paksham> getPakshamById(@PathVariable Long id) {
		return repo.findById(id).map(n -> ResponseEntity.ok().body(n))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/deletePaksham/{id}")
	public ResponseEntity<List<Paksham>> deletePaksham(@PathVariable Long id) {

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

	@PostMapping("/addPaksham")
	public ResponseEntity<Paksham> addPaksham(@RequestBody Paksham Paksham) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(Paksham));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/refreshPakshamList")
	public ResponseEntity<Boolean> refreshAllPakshamList() {
		List<Paksham> entryList = repo.findAll();
		entryList.sort(Comparator.comparingLong(Paksham::getId));

		allObjectsList = entryList;
		return ResponseEntity.ok(true);

	}

	public Map<Long, Paksham> getAsMap() {
		return (Map<Long, Paksham>) this.allObjectsList.stream().collect(Collectors.toMap(Paksham::getId, k  -> k));
	}

}
