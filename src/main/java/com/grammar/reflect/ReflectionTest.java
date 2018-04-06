package com.grammar.reflect;

import java.lang.reflect.Modifier;

public class ReflectionTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class cl = Class.forName("java.lang.Double");
		Class suppercl = cl.getSuperclass();
		System.out.println(Modifier.toString(cl.getModifiers()));
		System.out.println(Modifier.toString(suppercl.getModifiers()));
	}
}
