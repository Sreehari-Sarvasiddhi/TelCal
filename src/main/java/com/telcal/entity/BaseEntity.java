package com.telcal.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.ToString;

@ToString
@MappedSuperclass
public class BaseEntity {

	@Id
	private Long id;
	private String name;
	private String peru;

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

}
