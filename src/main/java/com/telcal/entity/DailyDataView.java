package com.telcal.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import com.telcal.transformers.DateStringConverter;
import com.telcal.transformers.LocalDateToStringConverter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "transformed_daily_data")
public class DailyDataView {

	@Id
	private Long id;

	@Temporal(TemporalType.DATE)
	@NotNull
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

	@Transient
	private LocalDateTime thidhi_from_en;
	@Transient
	private LocalDateTime thidhi_to_en;
	@Transient
	private LocalDateTime thidhi_from_te;
	@Transient
	private LocalDateTime thidhi_to_te;

	@Transient
	private LocalDateTime nakshatram_from_en;
	@Transient
	private LocalDateTime nakshatram_to_en;
	@Transient
	private LocalDateTime nakshatram_from_te;
	@Transient
	private LocalDateTime nakshatram_to_te;

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

	private String raahu_kaalam_from;
	private String raahu_kaalam_to;
	private String yama_gandam_from;
	private String yama_gandam_to;

	@Transient
	private List<Amrutham> amruthamList;

	@Transient
	private List<Varjyam> varjyamList;

	@Transient
	private List<Durmuhurtham> durmuharthamList;

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

	public String getThidhi_from_en() {
		return DateStringConverter.convertToOrdinalString(this, thidhi_from, true);
	}

	public void setThidhi_from_en(LocalDateTime thidhi_from_en) {
		this.thidhi_from_en = thidhi_from_en;
	}

	public String getThidhi_to_en() {
		return DateStringConverter.convertToOrdinalString(this, thidhi_to, true);
	}

	public void setThidhi_to_en(LocalDateTime thidhi_to_en) {
		this.thidhi_to_en = thidhi_to_en;
	}

	public String getThidhi_from_te() {
		return DateStringConverter.convertToOrdinalString(this, thidhi_from, false);
	}

	public void setThidhi_from_te(LocalDateTime thidhi_from_te) {
		this.thidhi_from_te = thidhi_from_te;
	}

	public String getThidhi_to_te() {
		return DateStringConverter.convertToOrdinalString(this, thidhi_to, false);
	}

	public void setThidhi_to_te(LocalDateTime thidhi_to_te) {
		this.thidhi_to_te = thidhi_to_te;
	}

	// -----

	private String checkAndGet(String input) {
		if (input == null) {
			return "";
		}
		return input;
	}

	public String getNakshatram_from_en() {
		return DateStringConverter.convertToOrdinalString(this, nakshatram_from, true);
	}

	public void setNakshatram_from_en(LocalDateTime nakshatram_from_en) {
		this.nakshatram_from_en = nakshatram_from_en;
	}

	public String getNakshatram_to_en() {
		return DateStringConverter.convertToOrdinalString(this, nakshatram_to, true);
	}

	public void setNakshatram_to_en(LocalDateTime nakshatram_to_en) {
		this.nakshatram_to_en = nakshatram_to_en;
	}

	public String getNakshatram_from_te() {
		return DateStringConverter.convertToOrdinalString(this, nakshatram_from, false);
	}

	public void setNakshatram_from_te(LocalDateTime nakshatram_from_te) {
		this.nakshatram_from_te = nakshatram_from_te;
	}

	public String getNakshatram_to_te() {
		return DateStringConverter.convertToOrdinalString(this, nakshatram_to, false);
	}

	public void setNakshatram_to_te(LocalDateTime nakshatram_to_te) {
		this.nakshatram_to_te = nakshatram_to_te;
	}

	public List<Amrutham> getAmruthamList() {
		return amruthamList;
	}

	public void setAmruthamList(List<Amrutham> amruthamList) {
		this.amruthamList = amruthamList;
	}

	public List<Varjyam> getVarjyamList() {
		return varjyamList;
	}

	public void setVarjyamList(List<Varjyam> varjyamList) {
		this.varjyamList = varjyamList;
	}

	public List<Durmuhurtham> getDurmuharthamList() {
		return durmuharthamList;
	}

	public void setDurmuharthamList(List<Durmuhurtham> durmuharthamList) {
		this.durmuharthamList = durmuharthamList;
	}

	public String getRaahu_kaalam_from() {
		return raahu_kaalam_from;
	}

	public void setRaahu_kaalam_from(String raahu_kaalam_from) {
		this.raahu_kaalam_from = raahu_kaalam_from;
	}

	public String getRaahu_kaalam_to() {
		return raahu_kaalam_to;
	}

	public void setRaahu_kaalam_to(String raahu_kaalam_to) {
		this.raahu_kaalam_to = raahu_kaalam_to;
	}

	public String getYama_gandam_from() {
		return yama_gandam_from;
	}

	public void setYama_gandam_from(String yama_gandam_from) {
		this.yama_gandam_from = yama_gandam_from;
	}

	public String getYama_gandam_to() {
		return yama_gandam_to;
	}

	public void setYama_gandam_to(String yama_gandam_to) {
		this.yama_gandam_to = yama_gandam_to;
	}

}
