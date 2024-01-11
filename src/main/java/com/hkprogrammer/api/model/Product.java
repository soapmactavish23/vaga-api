package com.hkprogrammer.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String name;
	
	@NotNull
	private Double value;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	private Integer code;
	
	@NotNull
	private Date date;
	
}
