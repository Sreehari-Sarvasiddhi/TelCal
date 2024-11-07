package com.telcal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location_data")
public class LocationData {

	@Id
	private Long id;
	private String name;
	private String peru;
	private Long time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeru() {
		return peru;
	}

	public void setPeru(String peru) {
		this.peru = peru;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "LocationData [id=" + id + ", name=" + name + ", peru=" + peru + ", time=" + time + "]";
	}

}
