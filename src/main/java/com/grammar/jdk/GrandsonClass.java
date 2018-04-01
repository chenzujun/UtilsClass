package com.grammar.jdk;

public class GrandsonClass extends SonClass {
	static {
		System.out.println("GrandsonClass init!");
	}

	public GrandsonClass() {
		System.out.println("init GrandsonClass");
	}
}
