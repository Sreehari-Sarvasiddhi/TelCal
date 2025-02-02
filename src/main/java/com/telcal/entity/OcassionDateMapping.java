package com.telcal.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ocassion_date_mapping")
public class OcassionDateMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "ocassion_id", nullable = false) // Foreign key reference to OcassionsList
	private OcassionsList ocassion;

	// Getters and Setters
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

	public OcassionsList getOcassion() {
		return ocassion;
	}

	public void setOcassion(OcassionsList ocassion) {
		this.ocassion = ocassion;
	}
}
