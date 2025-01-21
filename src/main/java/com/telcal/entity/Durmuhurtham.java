package com.telcal.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.telcal.transformers.LocalDateToStringConverter;
import com.telcal.util.DailyDataOrdinalUtil;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "durmuhurtham")
public class Durmuhurtham {

	@Id
	private Long id;
	private LocalDate date;
	private String from_time;
	private String to_time;
	private boolean is_exist;

	@Transient
	private String timingsAsStringEn;

	@Transient
	private String timingsAsStringTe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return LocalDateToStringConverter.convertLocalDatetoString(date);
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getFrom_time() {
		return from_time;
	}

	public void setFrom_time(String from_time) {
		this.from_time = from_time;
	}

	public String getTo_time() {
		return to_time;
	}

	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}

	public boolean isIs_exist() {
		return is_exist;
	}

	public void setIs_exist(boolean is_exist) {
		this.is_exist = is_exist;
	}

	public String getTimingsAsStringByDesantharakalamEn(int desantharakalam, DailyDataOrdinalUtil ordinalUtil) {

		return ordinalUtil.adjustOrdinalsForAmrutham(
				LocalDateTime.parse(from_time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
						.plusMinutes(desantharakalam),
				LocalDateTime.parse(to_time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
						.plusMinutes(desantharakalam),
				true);
	}

	public String getTimingsAsStringByDesantharakalamTe(int desantharakalam, DailyDataOrdinalUtil ordinalUtil) {

		return ordinalUtil.adjustOrdinalsForAmrutham(
				LocalDateTime.parse(from_time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
						.plusMinutes(desantharakalam),
				LocalDateTime.parse(to_time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
						.plusMinutes(desantharakalam),
				false);
	}

}
