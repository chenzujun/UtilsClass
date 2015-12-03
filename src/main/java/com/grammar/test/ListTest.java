package com.grammar.test;

import java.util.Random;


public class ListTest
{

    public static void main(String[] args)
    {
//     List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//     Map<String, String> map = new HashMap<String, String>();
//     map.put("1", "hi");
//     list.add(map);
//     
//     Map<String, String> map2 = new HashMap<String, String>();
//     map2.put("2", "hello");
//     list.add(map2);
//     
//     System.out.println(list.toString());
     
//        String districtfinance = "冯诗玮(比亚迪精密电子有限公司)";
//        int c = districtfinance.indexOf("(");
//        System.out.println(districtfinance.indexOf("（"));
//        System.out.println(districtfinance.substring(0, c));
    	Random random = new Random();
		for (int i = 0; i < 100; i++) {
			System.out.println(random.nextInt(100)+1);
		}
    }
}
