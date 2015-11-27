package com.grammar.number;

import java.math.BigDecimal;
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

	public static Double saveDecimals(double d,int scale){
		if(scale<0){
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
		BigDecimal bg = new BigDecimal(d);  
        Double d_result = bg.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();  
        
        return d_result;
	}
	
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Double d = 1323432.131313;
		BigDecimal bg = new BigDecimal(d);  
		System.out.println(bg.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(bg.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
	}

}
