package org.petka.modules.serviceone.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiParam;

public class ResponseOne {

	@ApiParam(value = "The age of the user", required = true)
	@NotNull
	private String age;

	@ApiParam(value = "Registered time.", required = true)
	@NotBlank
	private String time;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
