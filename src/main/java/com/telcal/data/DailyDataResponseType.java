package com.telcal.data;

public class DailyDataResponseType {
	private Long id = -999L;
	private String date = "";
	private String samvathsaram = "";
	private String ayanam = "";
	private String ruthuvu = "";
	private String month = "";
	private String day = "";
	private String maasam = "";
	private String paksham = "";
	private String thidhi = "";
	private String nakshatram = "";
	private String thidhi_from = "";
	private String thidhi_to = "";
	private String thidhi_full = "";
	private String nakshatram_from = "";
	private String nakshatram_to = "";
	private String nakshatram_ful = "";
	private String sunrise = "";
	private String sunset = "";
	private String occasion = "";
	private String error = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public String getThidhi_from() {
		return thidhi_from;
	}

	public void setThidhi_from(String thidhi_from) {
		this.thidhi_from = thidhi_from;
	}

	public String getThidhi_to() {
		return thidhi_to;
	}

	public void setThidhi_to(String thidhi_to) {
		this.thidhi_to = thidhi_to;
	}

	public String getNakshatram_from() {
		return nakshatram_from;
	}

	public void setNakshatram_from(String nakshatram_from) {
		this.nakshatram_from = nakshatram_from;
	}

	public String getNakshatram_to() {
		return nakshatram_to;
	}

	public void setNakshatram_to(String nakshatram_to) {
		this.nakshatram_to = nakshatram_to;
	}

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getThidhi_full() {
		return thidhi_full;
	}

	public void setThidhi_full(String thidhi_full) {
		this.thidhi_full = thidhi_full;
	}

	public String getNakshatram_ful() {
		return nakshatram_ful;
	}

	public void setNakshatram_ful(String nakshatram_ful) {
		this.nakshatram_ful = nakshatram_ful;
	}

	@Override
	public String toString() {
		return "DailyDataResponseType [id=" + id + ", date=" + date + ", samvathsaram=" + samvathsaram + ", ayanam="
				+ ayanam + ", ruthuvu=" + ruthuvu + ", month=" + month + ", day=" + day + ", maasam=" + maasam
				+ ", paksham=" + paksham + ", thidhi=" + thidhi + ", nakshatram=" + nakshatram + ", thidhi_from="
				+ thidhi_from + ", thidhi_to=" + thidhi_to + ", thidhi_full=" + thidhi_full + ", nakshatram_from="
				+ nakshatram_from + ", nakshatram_to=" + nakshatram_to + ", nakshatram_ful=" + nakshatram_ful
				+ ", sunrise=" + sunrise + ", sunset=" + sunset + ", occasion=" + occasion + ", error=" + error + "]";
	}

}
