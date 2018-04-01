package com.grammar.jdk;

public class SonClass extends SSClass {
	static {
		System.out.println("SonClass init");
	}

	public static int value = 123;

	public SonClass() {
		System.out.println("init SonClass");
	}
}
