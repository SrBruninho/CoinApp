package com.capp.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class BrentOil {
	
	private String monetaryBase;
	private LocalDate currentDate;
	private Double brentRate;
	private String unit;

}