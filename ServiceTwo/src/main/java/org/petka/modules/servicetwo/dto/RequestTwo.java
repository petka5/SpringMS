package org.petka.modules.servicetwo.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class RequestTwo {

	@NotNull
	private String name;

	@Length(min = 3, max = 5, message = "Lenght must be between 3 and 5.")
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
