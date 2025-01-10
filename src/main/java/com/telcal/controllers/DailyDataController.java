package com.telcal.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telcal.data.UserData;
import com.telcal.entity.Amrutham;
import com.telcal.entity.DailyDataView;
import com.telcal.entity.Durmuhurtham;
import com.telcal.entity.Varjyam;
import com.telcal.repositories.AmruthamRepo;
import com.telcal.repositories.DailyDataRepo;
import com.telcal.repositories.DailyDataViewRepo;
import com.telcal.repositories.DurmuhurthamRepo;
import com.telcal.repositories.VarjyamRepo;
import com.telcal.transformers.DailyDataTransformer;

import jakarta.servlet.http.HttpServletRequest;
import util.DateTimeUtils;

@RestController
@CrossOrigin
public class DailyDataController {

	@Autowired
	DailyDataRepo repo;

	@Autowired
	DailyDataViewRepo dailyDataViewRepo;

	@Autowired
	AmruthamRepo amruthamRepo;

	@Autowired
	VarjyamRepo varjyamRepo;

	@Autowired
	DurmuhurthamRepo durmuhurthamRepo;

	@Autowired
	DailyDataTransformer transformer;

	@PostMapping("/getTransoformedDataByDate")
	@CrossOrigin(originPatterns = { "*://*/*" }, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
			RequestMethod.DELETE }, allowedHeaders = { "Content-Type", "Accept", "X-Requested-With",
					"Authorization" }, exposedHeaders = { "Location", "Content-Disposition", "Content-Type", "Accept",
							"Authorization" }, maxAge = 3600, allowCredentials = "true")

	public ResponseEntity<List<DailyDataView>> getTransformedDataByDate(@RequestHeader("x-lang") String lang,
			@RequestBody UserData user, HttpServletRequest httpRequest) throws Exception {
		String date = user.getDate();
		int desantharakalam = user.getDesantharakalam();

		System.out.println("Get Data By Date : " + date);
		System.out.println("Get Data By Desantharakalam : " + desantharakalam);

		String origin = "*";

		if (!httpRequest.getHeader("Access-Control-Allow-Origin").isEmpty())
			origin = httpRequest.getHeader("Access-Control-Allow-Origin").toString();

		System.out.println("origin being passed as  " + origin);

		List<DailyDataView> repoResult = dailyDataViewRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		List<Amrutham> amruthamData = amruthamRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		List<Varjyam> varjyamData = varjyamRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		List<Durmuhurtham> durmuhurthamData = durmuhurthamRepo
				.findByDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));

		if (repoResult.size() == 0) {
			List<DailyDataView> respList = new ArrayList<>();
			DailyDataView resp = new DailyDataView();
			resp.setDate(DateTimeUtils.convertStringtoLocalDate(DateTimeUtils.convertDateStringFormat(date)));
			resp.setError("No Data Found");
			respList.add(resp);
			return ResponseEntity.ok().headers(getCorHeaders(origin)).body(respList);
		} else {

//			adjustResultsToDesantharaKaalam(repoResult);

			repoResult.forEach(k -> {
				k.setError("");

				k.setAmruthamListEn(amruthamData.stream().map(item -> item.getTimingsAsStringEn()).toList());
				k.setAmruthamListTe(amruthamData.stream().map(item -> item.getTimingsAsStringTe()).toList());

				k.setVarjyamListEn(varjyamData.stream().map(item -> item.getTimingsAsStringEn()).toList());
				k.setVarjyamListTe(varjyamData.stream().map(item -> item.getTimingsAsStringTe()).toList());

				k.setDurmuhurthamListEn(durmuhurthamData.stream().map(item -> item.getTimingsAsStringEn()).toList());
				k.setDurmuhurthamListTe(durmuhurthamData.stream().map(item -> item.getTimingsAsStringTe()).toList());

			});
			return ResponseEntity.ok().headers(getCorHeaders(origin)).body(repoResult);
		}
	}

//	private void adjustResultsToDesantharaKaalam(List<DailyDataView> repoResult) {
//		// TODO Auto-generated method stub
//		
//	}

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
