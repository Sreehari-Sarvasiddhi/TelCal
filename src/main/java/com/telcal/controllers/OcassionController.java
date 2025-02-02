package com.telcal.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/getAllOcassionsByMonth")
	public List<OcassionsList> getOcassionsByMonth(@RequestBody UserData userdata) {

		LocalDate date = DateTimeUtils
				.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(userdata.getDate()));

		return repo.findAllOcassionsByMonth(date);
	}

	@GetMapping("/getAllOcassionsByYear")
	public List<OcassionsList> getOcassionsByYear(@RequestBody UserData userdata) {

		LocalDate date = DateTimeUtils
				.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(userdata.getDate()));

		return repo.findAllOcassionsByYear(date);
	}
}
