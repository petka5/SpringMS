package org.petka.modules.serviceone.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiParam;

public class RequestOne {

	@ApiParam(value = "The name of the user", required = true)
	@NotNull
	private String name;

	@ApiParam(value = "The value", required = false)
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
