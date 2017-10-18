package com.model.entity;

import lombok.Getter;
import lombok.Setter;

public class Student {
@Getter@Setter

	private Long id;
	@Getter@Setter
	private  String name;
	@Getter@Setter
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
