package com.telcal.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telcal.data.UserData;
import com.telcal.entity.OcassionsList;
import com.telcal.repositories.OcassionDateMappingRepository;
import com.telcal.util.DateTimeUtils;

@RestController
@RequestMapping("/ocassions")
public class OcassionController {

	@Autowired
	OcassionDateMappingRepository repo;

	@PostMapping("/getAllOcassionsByMonth")
	public ResponseEntity<List<OcassionsList>> getOcassionsByMonth(@RequestBody UserData userdata) {

		LocalDate date = DateTimeUtils
				.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(userdata.getDate()));

		String origin = "*";

		return ResponseEntity.ok().headers(getCorHeaders(origin)).body(repo.findAllOcassionsByMonth(date));
	}

	@PostMapping("/getAllOcassionsByYear")
	public ResponseEntity<List<OcassionsList>> getOcassionsByYear(@RequestBody UserData userdata) {

		LocalDate date = DateTimeUtils
				.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(userdata.getDate()));

		String origin = "*";

		return ResponseEntity.ok().headers(getCorHeaders(origin)).body(repo.findAllOcassionsByYear(date));
	}

	@PostMapping("/getAllOcassionsBySamvathsaram")
	public ResponseEntity<List<OcassionsList>> getOcassionsBySamvathsaram(@RequestBody UserData userdata) {

		String origin = "*";

		return ResponseEntity.ok().headers(getCorHeaders(origin))
				.body(repo.findAllOcassionsBySamvathsaram(userdata.getSamvathsaram()));
	}

	public HttpHeaders getCorHeaders(String origin) {
		HttpHeaders headers = new HttpHeaders();

		headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Authorization");
		headers.add("Access-Control-Expose-Headers",
				"Location, Content-Disposition, Content-Type, Accept, Authorization");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Allow-Credentials", "true");

		headers.add("Access-Control-Allow-Origin", origin);
		return headers;

	}
}
