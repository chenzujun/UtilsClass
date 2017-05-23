package com.grammar.number;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal  d = new BigDecimal("152.2654");
		BigDecimal  d1 = new BigDecimal("1.634");
		
		System.out.println(d.add(d1).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
	}
}
