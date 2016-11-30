package com.tdu.simple.test.validate;

import javax.validation.constraints.NotNull;

public class SimpleBean {

	@TValidator(required = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull
	private String name2;
	
	

}
