package com.grammar.number;

public class DivisionTest {

	public static void divisionInt(Integer a, int b){
		double rate_tmp = a;
		
		int rate = (int) (rate_tmp/b*100);
		System.out.println(rate);
	}
	
	public static void main(String[] args) {
//		divisionInt(new Integer(8), 9);
		
		System.out.println(4/5);
		System.out.println(4/(5*0.01));
		System.out.println(4/(5*0.01)*100);
	}
}
