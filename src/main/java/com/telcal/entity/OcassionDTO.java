package com.telcal.entity;

import java.time.LocalDate;
import java.util.Date;

public class OcassionDTO {
	private LocalDate ocassionDate;
	private String ocassionName;
	private String ocassionPeru;
	private String monthName;
	private String monthPeru;
	private Integer dayOfMonth;

	// Default constructor
	public OcassionDTO() {
	}

	// Constructor used in JPA query
	public OcassionDTO(Date ocassionDate, String ocassionName, String ocassionPeru, String monthName, String monthPeru,
			Integer dayOfMonth) {
		this.ocassionDate = ocassionDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate(); // Convert
																												// Date
																												// to
																												// LocalDate
		this.ocassionName = ocassionName;
		this.ocassionPeru = ocassionPeru;
		this.monthName = monthName;
		this.monthPeru = monthPeru;
		this.dayOfMonth = dayOfMonth;
	}

	// Getters and Setters
	public LocalDate getOcassionDate() {
		return ocassionDate;
	}

	public void setOcassionDate(LocalDate ocassionDate) {
		this.ocassionDate = ocassionDate;
	}

	public String getOcassionName() {
		return ocassionName;
	}

	public void setOcassionName(String ocassionName) {
		this.ocassionName = ocassionName;
	}

	public String getOcassionPeru() {
		return ocassionPeru;
	}

	public void setOcassionPeru(String ocassionPeru) {
		this.ocassionPeru = ocassionPeru;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public String getMonthPeru() {
		return monthPeru;
	}

	public void setMonthPeru(String monthPeru) {
		this.monthPeru = monthPeru;
	}

	public Integer getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(Integer dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
}
