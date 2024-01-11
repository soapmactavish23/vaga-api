package com.hkprogrammer.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
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

	@NotNull
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@NotBlank
	@Size(min = 3, max = 100)
	private String name;

	@NotNull
	private Double value;

	private Integer quantity;

	@NotNull
	private Integer code;

	private Date date;

	@PrePersist
	public void setValues() {
		if (getDate() == null) {
			setDate(new Date());
		}

		Integer qtd = getQuantity();
		Double originalValue = getValue();
		Double finalValue = getValue();

		if (qtd == null) {
			setQuantity(1);
		} else {
			if (qtd > 10) {
				finalValue = originalValue * (1 - 10 / 100.0);
			} else if (qtd > 5) {
				finalValue = originalValue * (1 - 5 / 100.0);
			}

			setValue(finalValue);
		}
	}

}
