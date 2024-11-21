package com.telcal.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.telcal.transformers.LocalDateToStringConverter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "transformed_daily_data")
public class DailyDataView {

	@Id
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
	private String thidhi_full;
	private LocalDateTime nakshatram_from;
	private LocalDateTime nakshatram_to;
	private String nakshatram_ful;
	private String sunrise;
	private String sunset;
	private String occasion;

	private String samvathsaram_peru;
	private String ayanam_peru;
	private String ruthuvu_peru;
	private String month_peru;
	private String day_peru;
	private String maasam_peru;
	private String paksham_peru;
	private String thidhi_peru;
	private String nakshatram_peru;

	@Transient
	private String error;

	public Long getId() {
		if (id != null) {
			return id;
		}

		return -999L;

	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return checkAndGet(LocalDateToStringConverter.convertLocalDatetoString(date));
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getSamvathsaram() {
		return checkAndGet(samvathsaram);
	}

	public void setSamvathsaram(String samvathsaram) {
		this.samvathsaram = samvathsaram;
	}

	public String getAyanam() {
		return checkAndGet(ayanam);
	}

	public void setAyanam(String ayanam) {
		this.ayanam = ayanam;
	}

	public String getRuthuvu() {
		return checkAndGet(ruthuvu);
	}

	public void setRuthuvu(String ruthuvu) {
		this.ruthuvu = ruthuvu;
	}

	public String getMonth() {
		return checkAndGet(month);
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return checkAndGet(day);
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMaasam() {
		return checkAndGet(maasam);
	}

	public void setMaasam(String maasam) {
		this.maasam = maasam;
	}

	public String getPaksham() {
		return checkAndGet(paksham);
	}

	public void setPaksham(String paksham) {
		this.paksham = paksham;
	}

	public String getThidhi() {
		return checkAndGet(thidhi);
	}

	public void setThidhi(String thidhi) {
		this.thidhi = thidhi;
	}

	public String getNakshatram() {
		return checkAndGet(nakshatram);
	}

	public void setNakshatram(String nakshatram) {
		this.nakshatram = nakshatram;
	}

	public String getThidhi_from() {
		return checkAndGet(LocalDateToStringConverter.convertLocalDateTimetoString(thidhi_from));
	}

	public void setThidhi_from(LocalDateTime thidhi_from) {
		this.thidhi_from = thidhi_from;
	}

	public String getThidhi_to() {
		return checkAndGet(LocalDateToStringConverter.convertLocalDateTimetoString(thidhi_to));
	}

	public void setThidhi_to(LocalDateTime thidhi_to) {
		this.thidhi_to = thidhi_to;
	}

	public String getThidhi_full() {
		return checkAndGet(thidhi_full);
	}

	public void setThidhi_full(String thidhi_full) {
		this.thidhi_full = thidhi_full;
	}

	public String getNakshatram_from() {
		return checkAndGet(LocalDateToStringConverter.convertLocalDateTimetoString(nakshatram_from));
	}

	public void setNakshatram_from(LocalDateTime nakshatram_from) {
		this.nakshatram_from = nakshatram_from;
	}

	public String getNakshatram_to() {
		return checkAndGet(LocalDateToStringConverter.convertLocalDateTimetoString(nakshatram_to));
	}

	public void setNakshatram_to(LocalDateTime nakshatram_to) {
		this.nakshatram_to = nakshatram_to;
	}

	public String getNakshatram_ful() {
		return checkAndGet(nakshatram_ful);
	}

	public void setNakshatram_ful(String nakshatram_ful) {
		this.nakshatram_ful = nakshatram_ful;
	}

	public String getSunrise() {
		return checkAndGet(sunrise);
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return checkAndGet(sunset);
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public String getOccasion() {
		return checkAndGet(occasion);
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getError() {
		return checkAndGet(error);
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSamvathsaram_peru() {
		return checkAndGet(samvathsaram_peru);
	}

	public void setSamvathsaram_peru(String samvathsaram_peru) {
		this.samvathsaram_peru = samvathsaram_peru;
	}

	public String getAyanam_peru() {
		return checkAndGet(ayanam_peru);
	}

	public void setAyanam_peru(String ayanam_peru) {
		this.ayanam_peru = ayanam_peru;
	}

	public String getRuthuvu_peru() {
		return checkAndGet(ruthuvu_peru);
	}

	public void setRuthuvu_peru(String ruthuvu_peru) {
		this.ruthuvu_peru = ruthuvu_peru;
	}

	public String getMonth_peru() {
		return checkAndGet(month_peru);
	}

	public void setMonth_peru(String month_peru) {
		this.month_peru = month_peru;
	}

	public String getDay_peru() {
		return checkAndGet(day_peru);
	}

	public void setDay_peru(String day_peru) {
		this.day_peru = day_peru;
	}

	public String getMaasam_peru() {
		return checkAndGet(maasam_peru);
	}

	public void setMaasam_peru(String maasam_peru) {
		this.maasam_peru = maasam_peru;
	}

	public String getPaksham_peru() {
		return checkAndGet(paksham_peru);
	}

	public void setPaksham_peru(String paksham_peru) {
		this.paksham_peru = paksham_peru;
	}

	public String getThidhi_peru() {
		return checkAndGet(thidhi_peru);
	}

	public void setThidhi_peru(String thidhi_peru) {
		this.thidhi_peru = thidhi_peru;
	}

	public String getNakshatram_peru() {
		return checkAndGet(nakshatram_peru);
	}

	public void setNakshatram_peru(String nakshatram_peru) {
		this.nakshatram_peru = nakshatram_peru;
	}

	private String checkAndGet(String input) {
		if (input == null) {
			return "";
		}
		return input;
	}

}
