package com.telcal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@ToString
@Table(name = "e_month")
public class Month extends BaseEntity {

}
