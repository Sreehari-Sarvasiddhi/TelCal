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

import com.telcal.entity.Nakshatram;
import com.telcal.repositories.NakshatramRepo;

@RestController
public class NakshatramController {

	@Autowired
	NakshatramRepo repo;

	private List<Nakshatram> allObjectsList;

	@GetMapping("/allNakshatrams")
	public ResponseEntity<List<Nakshatram>> getAllNakshatramList() {
		if (allObjectsList == null || allObjectsList.isEmpty()) {
			List<Nakshatram> entryList = repo.findAll();
			entryList.sort(Comparator.comparingLong(Nakshatram::getId));
			allObjectsList = entryList;

			return ResponseEntity.ok().body(entryList);
		} else {
			return ResponseEntity.ok(allObjectsList);
		}
	}

	@GetMapping("/nakshatramById/{id}")
	public ResponseEntity<Nakshatram> getNakshatramById(@PathVariable Long id) {
		return repo.findById(id).map(n -> ResponseEntity.ok().body(n))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/deleteNakshatram/{id}")
	public ResponseEntity<List<Nakshatram>> deleteNakshatram(@PathVariable Long id) {

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

	@PostMapping("/addNakshatram")
	public ResponseEntity<Nakshatram> addNakshatram(@RequestBody Nakshatram nakshatram) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(nakshatram));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/refreshNakshatramList")
	public ResponseEntity<Boolean> refreshAllNakshatramList() {
		List<Nakshatram> entryList = repo.findAll();
		entryList.sort(Comparator.comparingLong(Nakshatram::getId));

		allObjectsList = entryList;
		return ResponseEntity.ok(true);

	}

	public Map<Long, Nakshatram> getAsMap() {
		return (Map<Long, Nakshatram>) this.allObjectsList.stream()
				.collect(Collectors.toMap(Nakshatram::getId, k -> k));
	}

}
