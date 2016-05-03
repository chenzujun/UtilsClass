package com.common.utils;

public class Test {

	public static void main(String[] args) {
		 System.out.println("EnumTest.FRI 的 value = " + EnumTest.FRI.getValue());
		 for (String string : EnumTest.SUN.getAlertPhones()) {
			System.out.println(string);
		}
	}
}
