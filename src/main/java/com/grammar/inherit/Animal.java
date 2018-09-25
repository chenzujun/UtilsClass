package com.grammar.inherit;


public class Animal extends Parent {

	public String name;
	public Integer age;
	private String privateVal;
	String defaultVal;
	protected String protectedVal;

	public Animal(){}

	public Animal(String name, Integer age, String privateVal, String defaultVal, String protectedVal) {
		this.name = name;
		this.age = age;
		this.privateVal = privateVal;
		this.defaultVal = defaultVal;
		this.protectedVal = protectedVal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPrivateVal() {
		return privateVal;
	}

	public void setPrivateVal(String privateVal) {
		this.privateVal = privateVal;
	}

	public String getDefaultVal() {
		return defaultVal;
	}

	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
	}

	public String getProtectedVal() {
		return protectedVal;
	}

	public void setProtectedVal(String protectedVal) {
		this.protectedVal = protectedVal;
	}

	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				", age=" + age +
				", privateVal='" + privateVal + '\'' +
				", defaultVal='" + defaultVal + '\'' +
				", protectedVal='" + protectedVal + '\'' +
				'}';
	}
}
