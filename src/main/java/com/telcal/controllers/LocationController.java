package com.telcal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telcal.entity.LocationData;
import com.telcal.repositories.LocationRepo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class LocationController {

	@Autowired
	LocationRepo repo;

	@GetMapping("/allLocationData")
	@CrossOrigin(originPatterns = { "*://*/*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.DELETE }, allowedHeaders = { "Content-Type", "Accept", "X-Requested-With",
					"Authorization" }, exposedHeaders = { "Location", "Content-Disposition", "Content-Type", "Accept",
							"Authorization" }, maxAge = 3600, allowCredentials = "true")

	public ResponseEntity<List<LocationData>> getdataByDate(@RequestHeader("x-lang") String lang,
			HttpServletRequest httpRequest) throws Exception {
		String origin = "*";

		if (!httpRequest.getHeader("Access-Control-Allow-Origin").isEmpty())
			origin = httpRequest.getHeader("Access-Control-Allow-Origin").toString();

		System.out.println("origin being passed as  " + origin);

		List<LocationData> repoResult = repo.findAll();

		return ResponseEntity.ok().headers(getCorHeaders(origin)).body(repoResult);

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
