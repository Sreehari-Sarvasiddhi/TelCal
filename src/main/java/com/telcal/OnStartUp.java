package com.telcal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telcal.controllers.AyanamController;
import com.telcal.controllers.DayController;
import com.telcal.controllers.MaasamController;
import com.telcal.controllers.MonthController;
import com.telcal.controllers.NakshatramController;
import com.telcal.controllers.PakshamController;
import com.telcal.controllers.RuthuvuController;
import com.telcal.controllers.SamvathsaramController;
import com.telcal.controllers.ThithiController;

import jakarta.annotation.PostConstruct;

@Component
public class OnStartUp {

	@Autowired
	SamvathsaramController samvathsaramController;

	@Autowired
	AyanamController ayanamController;

	@Autowired
	RuthuvuController ruthuvuController;

	@Autowired
	MaasamController maasamController;

	@Autowired
	PakshamController pakshamController;

	@Autowired
	ThithiController thithiController;

	@Autowired
	DayController dayController;

	@Autowired
	MonthController monthController;

	@Autowired
	NakshatramController nakshatramController;

	@PostConstruct
	public void runAfterStartup() {
		samvathsaramController.getAllSamvathsaramList();
		ayanamController.getAllAyanamList();
		ruthuvuController.getAllRuthuvuList();
		maasamController.getAllMaasamList();
		pakshamController.getAllPakshamList();
		thithiController.getAllThithiList();
		dayController.getAllDayList();
		monthController.getAllMonthList();
		nakshatramController.getAllNakshatramList();

		System.out.println("App is up, bitch!!");
	}

}
