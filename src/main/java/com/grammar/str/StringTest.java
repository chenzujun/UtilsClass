package com.grammar.str;

import org.apache.commons.lang.StringUtils;

public class StringTest {

	public static void testStringBuffer(){
		StringBuffer sb = new StringBuffer();

		if(StringUtils.isNotEmpty(sb.toString())){
			System.out.println("length:"+sb.length());
		}
	}

	public static void main(String[] args) {
		testStringBuffer();
	}
	
}
