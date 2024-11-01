package com.telcal.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "daily_data")
public class DailyData {

	@Id
	private Long id;
	private LocalDate date;
	private Long t_samvathsaram_id;
	private Long t_ayanam_id;
	private Long t_ruthuvu_id;
	private Long e_month_id;
	private Long e_day_id;
	private Long t_maasam_id;
	private Long t_paksham_id;
	private Long t_thidhi_id;
	private Long t_nakshatram_id;

	@Nullable
	private LocalDateTime t_thidhi_from;
	@Nullable
	private LocalDateTime t_thidhi_to;
	@Nullable
	private LocalDateTime t_nakshatram_from;
	@Nullable
	private LocalDateTime t_nakshatram_to;
	private LocalTime sunrise;
	private LocalTime sunset;
	private String occasion;

	private String t_thidhi_full;
	private String t_nakshatram_ful;

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

	public Long getT_samvathsaram_id() {
		return t_samvathsaram_id;
	}

	public void setT_samvathsaram_id(Long t_samvathsaram_id) {
		this.t_samvathsaram_id = t_samvathsaram_id;
	}

	public Long getT_ayanam_id() {
		return t_ayanam_id;
	}

	public void setT_ayanam_id(Long t_ayanam_id) {
		this.t_ayanam_id = t_ayanam_id;
	}

	public Long getT_ruthuvu_id() {
		return t_ruthuvu_id;
	}

	public void setT_ruthuvu_id(Long t_ruthuvu_id) {
		this.t_ruthuvu_id = t_ruthuvu_id;
	}

	public Long getE_month_id() {
		return e_month_id;
	}

	public void setE_month_id(Long e_month_id) {
		this.e_month_id = e_month_id;
	}

	public Long getE_day_id() {
		return e_day_id;
	}

	public void setE_day_id(Long e_day_id) {
		this.e_day_id = e_day_id;
	}

	public Long getT_maasam_id() {
		return t_maasam_id;
	}

	public void setT_maasam_id(Long t_maasam_id) {
		this.t_maasam_id = t_maasam_id;
	}

	public Long getT_paksham_id() {
		return t_paksham_id;
	}

	public void setT_paksham_id(Long t_paksham_id) {
		this.t_paksham_id = t_paksham_id;
	}

	public Long getT_thidhi_id() {
		return t_thidhi_id;
	}

	public void setT_thidhi_id(Long t_thidhi_id) {
		this.t_thidhi_id = t_thidhi_id;
	}

	public Long getT_nakshatram_id() {
		return t_nakshatram_id;
	}

	public void setT_nakshatram_id(Long t_nakshatram_id) {
		this.t_nakshatram_id = t_nakshatram_id;
	}

	public LocalDateTime getT_thidhi_from() {
		return t_thidhi_from;
	}

	public void setT_thidhi_from(LocalDateTime t_thidhi_from) {
		this.t_thidhi_from = t_thidhi_from;
	}

	public LocalDateTime getT_thidhi_to() {
		return t_thidhi_to;
	}

	public void setT_thidhi_to(LocalDateTime t_thidhi_to) {
		this.t_thidhi_to = t_thidhi_to;
	}

	public LocalDateTime getT_nakshatram_from() {
		return t_nakshatram_from;
	}

	public void setT_nakshatram_from(LocalDateTime t_nakshatram_from) {
		this.t_nakshatram_from = t_nakshatram_from;
	}

	public LocalDateTime getT_nakshatram_to() {
		return t_nakshatram_to;
	}

	public void setT_nakshatram_to(LocalDateTime t_nakshatram_to) {
		this.t_nakshatram_to = t_nakshatram_to;
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

	public String getT_thidhi_full() {
		return t_thidhi_full;
	}

	public void setT_thidhi_full(String t_thidhi_full) {
		this.t_thidhi_full = t_thidhi_full;
	}

	public String getT_nakshatram_ful() {
		return t_nakshatram_ful;
	}

	public void setT_nakshatram_ful(String t_nakshatram_ful) {
		this.t_nakshatram_ful = t_nakshatram_ful;
	}

	@Override
	public String toString() {
		return "DailyData [id=" + id + ", date=" + date + ", t_samvathsaram_id=" + t_samvathsaram_id + ", t_ayanam_id="
				+ t_ayanam_id + ", t_ruthuvu_id=" + t_ruthuvu_id + ", e_month_id=" + e_month_id + ", e_day_id="
				+ e_day_id + ", t_maasam_id=" + t_maasam_id + ", t_paksham_id=" + t_paksham_id + ", t_thidhi_id="
				+ t_thidhi_id + ", t_nakshatram_id=" + t_nakshatram_id + ", t_thidhi_from=" + t_thidhi_from
				+ ", t_thidhi_to=" + t_thidhi_to + ", t_nakshatram_from=" + t_nakshatram_from + ", t_nakshatram_to="
				+ t_nakshatram_to + ", sunrise=" + sunrise + ", sunset=" + sunset + ", occasion=" + occasion
				+ ", t_thidhi_full=" + t_thidhi_full + ", t_nakshatram_ful=" + t_nakshatram_ful + "]";
	}

}
