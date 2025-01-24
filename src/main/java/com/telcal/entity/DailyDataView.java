package com.telcal.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.text.WordUtils;

import com.telcal.transformers.LocalDateToStringConverter;
import com.telcal.util.DateTimeUtils;

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

	public LocalDateTime thidhi_from;
	public LocalDateTime thidhi_to;

	private String day_desc_en;
	private String day_desc_te;

	@Transient
	private String thidhi_from_en;
	@Transient
	private String thidhi_to_en;
	@Transient
	private String thidhi_from_te;
	@Transient
	private String thidhi_to_te;

	@Transient
	private String nakshatram_from_en;
	@Transient
	private String nakshatram_to_en;
	@Transient
	private String nakshatram_from_te;
	@Transient
	private String nakshatram_to_te;

	private String thidhi_full;
	public LocalDateTime nakshatram_from;
	public LocalDateTime nakshatram_to;
	private String nakshatram_ful;
	private String sunrise;
	private String sunset;

	@Transient
	private List<String> occasionEn;

	@Transient
	private List<String> occasionTe;

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
	private String getRaahukaalamAsStringEn;
	@Transient
	private String getRaahukaalamAsStringTe;
	@Transient
	private String getYamagandamAsStringEn;
	@Transient
	private String getYamagandamAsStringTe;

	@Transient
	private List<String> amruthamListEn;

	@Transient
	private List<String> varjyamListEn;

	@Transient
	private List<String> durmuhurthamListEn;

	@Transient
	private List<String> amruthamListTe;

	@Transient
	private List<String> varjyamListTe;

	@Transient
	private List<String> durmuhurthamListTe;

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

	public List<String> getOccasionEn() {
		return occasionEn;
	}

	public void setOccasionEn(List<String> occasionEn) {
		this.occasionEn = occasionEn;
	}

	public List<String> getOccasionTe() {
		return occasionTe;
	}

	public void setOccasionTe(List<String> occasionTe) {
		this.occasionTe = occasionTe;
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
		return WordUtils.capitalizeFully(input);
	}

	public String getRaahu_kaalam_from() {
		return raahu_kaalam_from;
	}

	public String getThidhi_from_en() {
		return thidhi_from_en;
	}

	public void setThidhi_from_en(String thidhi_from_en) {
		this.thidhi_from_en = thidhi_from_en;
	}

	public String getThidhi_to_en() {
		return thidhi_to_en;
	}

	public void setThidhi_to_en(String thidhi_to_en) {
		this.thidhi_to_en = thidhi_to_en;
	}

	public String getThidhi_from_te() {
		return thidhi_from_te;
	}

	public void setThidhi_from_te(String thidhi_from_te) {
		this.thidhi_from_te = thidhi_from_te;
	}

	public String getThidhi_to_te() {
		return thidhi_to_te;
	}

	public void setThidhi_to_te(String thidhi_to_te) {
		this.thidhi_to_te = thidhi_to_te;
	}

	public String getNakshatram_from_en() {
		return nakshatram_from_en;
	}

	public void setNakshatram_from_en(String nakshatram_from_en) {
		this.nakshatram_from_en = nakshatram_from_en;
	}

	public String getNakshatram_to_en() {
		return nakshatram_to_en;
	}

	public void setNakshatram_to_en(String nakshatram_to_en) {
		this.nakshatram_to_en = nakshatram_to_en;
	}

	public String getNakshatram_from_te() {
		return nakshatram_from_te;
	}

	public void setNakshatram_from_te(String nakshatram_from_te) {
		this.nakshatram_from_te = nakshatram_from_te;
	}

	public String getNakshatram_to_te() {
		return nakshatram_to_te;
	}

	public void setNakshatram_to_te(String nakshatram_to_te) {
		this.nakshatram_to_te = nakshatram_to_te;
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

	public String getDay_desc_en() {
		return WordUtils.capitalizeFully(day_desc_en);
	}

	public void setDay_desc_en(String day_desc_en) {
		this.day_desc_en = day_desc_en;
	}

	public String getDay_desc_te() {
		return WordUtils.capitalizeFully(day_desc_te);
	}

	public void setDay_desc_te(String day_desc_te) {
		this.day_desc_te = day_desc_te;
	}

	public List<String> getAmruthamListEn() {
		return amruthamListEn;
	}

	public void setAmruthamListEn(List<String> amruthamListEn) {
		this.amruthamListEn = amruthamListEn;
	}

	public List<String> getVarjyamListEn() {
		return varjyamListEn;
	}

	public void setVarjyamListEn(List<String> varjyamListEn) {
		this.varjyamListEn = varjyamListEn;
	}

	public List<String> getAmruthamListTe() {
		return amruthamListTe;
	}

	public void setAmruthamListTe(List<String> amruthamListTe) {
		this.amruthamListTe = amruthamListTe;
	}

	public List<String> getVarjyamListTe() {
		return varjyamListTe;
	}

	public void setVarjyamListTe(List<String> varjyamListTe) {
		this.varjyamListTe = varjyamListTe;
	}

	public List<String> getDurmuhurthamListTe() {
		return durmuhurthamListTe;
	}

	public void setDurmuhurthamListTe(List<String> durmuhurthamListTe) {
		this.durmuhurthamListTe = durmuhurthamListTe;
	}

	public List<String> getDurmuhurthamListEn() {
		return durmuhurthamListEn;
	}

	public void setDurmuhurthamListEn(List<String> durmuhurthamListEn) {
		this.durmuhurthamListEn = durmuhurthamListEn;
	}

	public String getGetRaahukaalamAsStringEn() {
		StringBuilder sb = new StringBuilder();

		sb.append("from " + DateTimeUtils.convertTimeToHHMM(raahu_kaalam_from) + " to "
				+ DateTimeUtils.convertTimeToHHMM(raahu_kaalam_to));

		return sb.toString();
	}

	public void setGetRaahukaalamAsStringEn(String getRaahukaalamAsStringEn) {
		this.getRaahukaalamAsStringEn = getRaahukaalamAsStringEn;
	}

	public String getGetRaahukaalamAsStringTe() {
		StringBuilder sb = new StringBuilder();

		sb.append(DateTimeUtils.convertTimeToHHMM(raahu_kaalam_from) + " నుండి "
				+ DateTimeUtils.convertTimeToHHMM(raahu_kaalam_to) + " వరకు");

		return sb.toString();
	}

	public void setGetRaahukaalamAsStringTe(String getRaahukaalamAsStringTe) {
		this.getRaahukaalamAsStringTe = getRaahukaalamAsStringTe;
	}

	public String getGetYamagandamAsStringEn() {
		StringBuilder sb = new StringBuilder();

		sb.append("from " + DateTimeUtils.convertTimeToHHMM(yama_gandam_from) + " to "
				+ DateTimeUtils.convertTimeToHHMM(yama_gandam_to));

		return sb.toString();
	}

	public void setGetYamagandamAsStringEn(String getYamagandamAsStringEn) {
		this.getYamagandamAsStringEn = getYamagandamAsStringEn;
	}

	public String getGetYamagandamAsStringTe() {
		StringBuilder sb = new StringBuilder();

		sb.append(DateTimeUtils.convertTimeToHHMM(yama_gandam_from) + " నుండి "
				+ DateTimeUtils.convertTimeToHHMM(yama_gandam_to) + " వరకు");

		return sb.toString();
	}

	public void setGetYamagandamAsStringTe(String getYamagandamAsStringTe) {
		this.getYamagandamAsStringTe = getYamagandamAsStringTe;
	}

}
