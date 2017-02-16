package com.common.util;

public class StringUtils {

	public static String interceptCharacter(){
		
		String districtfinance = "冯诗玮(比亚迪精密电子有限公司)";
        int c = districtfinance.indexOf("(");
        System.out.println(districtfinance.indexOf("（"));
        System.out.println(districtfinance.substring(0, c));
        return null;
	}
	
	public static void main(String[] args) {
		String districtfinance = "邀约一军二区（苗春雷）";
        int c = districtfinance.indexOf("（");
        System.out.println(districtfinance.indexOf("冯"));
        System.out.println(districtfinance.substring(c-2, c));
	}
	
}
