package com.dynamicproxy;

public class Manager implements Employee {

	@Override
	public void getName() {
		System.out.println("manager");
	}
}
