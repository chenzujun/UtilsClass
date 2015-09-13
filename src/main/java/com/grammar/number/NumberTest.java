package com.grammar.number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTest {

	public static String formatNumber5(String iniNum, int split) {
		// ①去掉所有逗号，并把串倒过来。
		StringBuffer tmp = new StringBuffer()
				.append(iniNum.replaceAll(",", "")).reverse(); 
		
		// ② 替换这样的串：连续split位数字的串，其右边还有个数字，在串的右边添加逗号

		String retNum = Pattern.compile("(\\d{" + split + "})(?=\\d)")
				.matcher(tmp.toString()).replaceAll("$1,");
		// ③ 替换完后，再把串倒回去返回
		return new StringBuffer().append(retNum).reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(formatNumber5("14564465233100.2", 3));
	}

}
