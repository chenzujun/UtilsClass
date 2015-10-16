package com.grammar.number;

import java.text.DecimalFormat;

public class DoubleTest {

	public static void main(String[] args) {
		Double d = new Double("1234567891.333");
		
		DecimalFormat df=new DecimalFormat("#,##0.00");
		System.out.println(df.format(d));
		Double resultD = d;
		
		System.out.println(resultD);
	}
}
