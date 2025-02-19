package com.telcal.entity;

import java.time.LocalDate;

import org.apache.commons.text.WordUtils;

import com.telcal.transformers.LocalDateToStringConverter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocassion_date_mapping_view")
public class OcassionsList {

	@Id
	private Long id;
	private LocalDate ocassion_date;
	private String ocassion_name;
	private String ocassion_peru;
	private String month_name;
	private String month_peru;
	private int date;
	private int month_number;
	private int year_number;
	private String day_desc_te;
	private String day_desc_en;
	private int samvathsaram_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOcassion_date() {
		return WordUtils
				.capitalizeFully(checkAndGet(LocalDateToStringConverter.convertLocalDatetoString(ocassion_date)));
//		return ocassion_date;
	}

	private String checkAndGet(String input) {
		if (input == null) {
			return "";
		}
		return WordUtils.capitalizeFully(input);
	}

	public void setOcassion_date(LocalDate ocassion_date) {
		this.ocassion_date = ocassion_date;
	}

	public String getOcassion_name() {
		return WordUtils.capitalizeFully(ocassion_name);
	}

	public void setOcassion_name(String ocassion_name) {
		this.ocassion_name = ocassion_name;
	}

	public String getOcassion_peru() {
		return WordUtils.capitalizeFully(ocassion_peru);
	}

	public void setOcassion_peru(String ocassion_peru) {
		this.ocassion_peru = ocassion_peru;
	}

	public String getMonth_name() {
		return WordUtils.capitalizeFully(month_name);
	}

	public void setMonth_name(String month_name) {
		this.month_name = month_name;
	}

	public String getMonth_peru() {
		return WordUtils.capitalizeFully(month_peru);
	}

	public void setMonth_peru(String month_peru) {
		this.month_peru = month_peru;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth_number() {
		return month_number;
	}

	public void setMonth_number(int month_number) {
		this.month_number = month_number;
	}

	public int getYear_number() {
		return year_number;
	}

	public void setYear_number(int year_number) {
		this.year_number = year_number;
	}

	public String getDay_desc_te() {
		return WordUtils.capitalizeFully(day_desc_te);
	}

	public void setDay_desc_te(String day_desc_te) {
		this.day_desc_te = day_desc_te;
	}

	public String getDay_desc_en() {
		return WordUtils.capitalizeFully(day_desc_en);
	}

	public void setDay_desc_en(String day_desc_en) {
		this.day_desc_en = day_desc_en;
	}

	public int getSamvathsaram_id() {
		return samvathsaram_id;
	}

	public void setSamvathsaram_id(int samvathsaram_id) {
		this.samvathsaram_id = samvathsaram_id;
	}

}
