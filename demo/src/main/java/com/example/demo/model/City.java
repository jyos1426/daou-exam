package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class City {
	private Integer id;
	private String Name;
	private String CountryCode;
	private String District;
	private Integer Population;
}
