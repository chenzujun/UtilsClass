package com.grammar.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListTest {

	public static void testFor(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : list) {
			System.out.println("empty");
		}
		
		List<Map<String,Object>> list2 = null;
		for (Map<String, Object> map : list2) {
			System.out.println("null");
		}
	}
	
	public static void main(String[] args) {
		testFor();
	}
}
