package com.mode.clone;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 2342777854118794173L;
	
	private String name;

	public Book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}