package com.telcal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "e_day")
public class Day extends BaseEntity {

	@Column(name = "short_peru")
	private String shortPeru;

}
