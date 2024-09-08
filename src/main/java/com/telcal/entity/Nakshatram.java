package com.telcal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Getter
@Setter
@ToString
@Table(name = "t_nakshatram")
public class Nakshatram extends BaseEntity {

}
