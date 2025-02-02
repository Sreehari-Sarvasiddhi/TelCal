package com.telcal.entity;

import java.time.LocalDate;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOcassion_date() {
		return ocassion_date;
	}

	public void setOcassion_date(LocalDate ocassion_date) {
		this.ocassion_date = ocassion_date;
	}

	public String getOcassion_name() {
		return ocassion_name;
	}

	public void setOcassion_name(String ocassion_name) {
		this.ocassion_name = ocassion_name;
	}

	public String getOcassion_peru() {
		return ocassion_peru;
	}

	public void setOcassion_peru(String ocassion_peru) {
		this.ocassion_peru = ocassion_peru;
	}

	public String getMonth_name() {
		return month_name;
	}

	public void setMonth_name(String month_name) {
		this.month_name = month_name;
	}

	public String getMonth_peru() {
		return month_peru;
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

}
