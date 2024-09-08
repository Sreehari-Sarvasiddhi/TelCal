package com.telcal.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DailyDataResponseType {
	private Long id;
	private LocalDate date;
	private String samvathsaram;
	private String ayanam;
	private String ruthuvu;
	private String month;
	private String day;
	private String maasam;
	private String paksham;
	private String thidhi;
	private String nakshatram;
	private LocalDateTime thidhi_from;
	private LocalDateTime thidhi_to;
	private LocalDateTime nakshatram_from;
	private LocalDateTime nakshatram_to;
	private LocalTime sunrise;
	private LocalTime sunset;
	private String occasion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSamvathsaram() {
		return samvathsaram;
	}

	public void setSamvathsaram(String samvathsaram) {
		this.samvathsaram = samvathsaram;
	}

	public String getAyanam() {
		return ayanam;
	}

	public void setAyanam(String ayanam) {
		this.ayanam = ayanam;
	}

	public String getRuthuvu() {
		return ruthuvu;
	}

	public void setRuthuvu(String ruthuvu) {
		this.ruthuvu = ruthuvu;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMaasam() {
		return maasam;
	}

	public void setMaasam(String maasam) {
		this.maasam = maasam;
	}

	public String getPaksham() {
		return paksham;
	}

	public void setPaksham(String paksham) {
		this.paksham = paksham;
	}

	public String getThidhi() {
		return thidhi;
	}

	public void setThidhi(String thidhi) {
		this.thidhi = thidhi;
	}

	public String getNakshatram() {
		return nakshatram;
	}

	public void setNakshatram(String nakshatram) {
		this.nakshatram = nakshatram;
	}

	public LocalDateTime getThidhi_from() {
		return thidhi_from;
	}

	public void setThidhi_from(LocalDateTime thidhi_from) {
		this.thidhi_from = thidhi_from;
	}

	public LocalDateTime getThidhi_to() {
		return thidhi_to;
	}

	public void setThidhi_to(LocalDateTime thidhi_to) {
		this.thidhi_to = thidhi_to;
	}

	public LocalDateTime getNakshatram_from() {
		return nakshatram_from;
	}

	public void setNakshatram_from(LocalDateTime nakshatram_from) {
		this.nakshatram_from = nakshatram_from;
	}

	public LocalDateTime getNakshatram_to() {
		return nakshatram_to;
	}

	public void setNakshatram_to(LocalDateTime nakshatram_to) {
		this.nakshatram_to = nakshatram_to;
	}

	public LocalTime getSunrise() {
		return sunrise;
	}

	public void setSunrise(LocalTime sunrise) {
		this.sunrise = sunrise;
	}

	public LocalTime getSunset() {
		return sunset;
	}

	public void setSunset(LocalTime sunset) {
		this.sunset = sunset;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

}
