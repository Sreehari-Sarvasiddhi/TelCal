package com.telcal.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocassions")
public class Ocassions {

	@Id
	private Long id;
	private LocalDate date;
	private String ocassion_en;
	private String ocassion_te;

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

	public String getOcassion_en() {
		return ocassion_en;
	}

	public void setOcassion_en(String ocassion_en) {
		this.ocassion_en = ocassion_en;
	}

	public String getOcassion_te() {
		return ocassion_te;
	}

	public void setOcassion_te(String ocassion_te) {
		this.ocassion_te = ocassion_te;
	}

}
