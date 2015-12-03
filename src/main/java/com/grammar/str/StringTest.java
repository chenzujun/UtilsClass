package com.grammar.str;

public class StringTest {

	public static void main(String[] args) {
		String calledPhone = "013661559297";
		calledPhone = calledPhone.replaceFirst("^0", "");
		System.out.println(calledPhone);
		
		
		String calledPhone2 = "013661559297";
		calledPhone2 = calledPhone2.replaceFirst("0", "");
		System.out.println(calledPhone2);
	}
	
}
