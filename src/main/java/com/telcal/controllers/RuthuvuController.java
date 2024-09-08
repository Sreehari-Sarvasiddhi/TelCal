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

import com.telcal.entity.Ruthuvu;
import com.telcal.repositories.RuthuvuRepo;

@RestController
public class RuthuvuController {

	@Autowired
	RuthuvuRepo repo;

	private List<Ruthuvu> allObjectsList;

	@GetMapping("/allRuthuvus")
	public ResponseEntity<List<Ruthuvu>> getAllRuthuvuList() {
		if (allObjectsList == null || allObjectsList.isEmpty()) {
			List<Ruthuvu> entryList = repo.findAll();
			entryList.sort(Comparator.comparingLong(Ruthuvu::getId));
			allObjectsList = entryList;

			return ResponseEntity.ok().body(entryList);
		} else {
			return ResponseEntity.ok(allObjectsList);
		}
	}

	@GetMapping("/ruthuvuById/{id}")
	public ResponseEntity<Ruthuvu> getRuthuvuById(@PathVariable Long id) {
		return repo.findById(id).map(n -> ResponseEntity.ok().body(n))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/deleteRuthuvu/{id}")
	public ResponseEntity<List<Ruthuvu>> deleteRuthuvu(@PathVariable Long id) {

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

	@PostMapping("/addRuthuvu")
	public ResponseEntity<Ruthuvu> addRuthuvu(@RequestBody Ruthuvu Ruthuvu) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(Ruthuvu));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/refreshRuthuvuList")
	public ResponseEntity<Boolean> refreshAllRuthuvuList() {
		List<Ruthuvu> entryList = repo.findAll();
		entryList.sort(Comparator.comparingLong(Ruthuvu::getId));

		allObjectsList = entryList;
		return ResponseEntity.ok(true);

	}

	public Map<Long, Ruthuvu> getAsMap() {
		return (Map<Long, Ruthuvu>) this.allObjectsList.stream().collect(Collectors.toMap(Ruthuvu::getId, k  -> k));
	}

}
