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
	
	public static void testRemove(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(22));
		list.add(new Integer(333));
		for (Integer in : list) {
			if(22 == in){
				list.remove(in);
			}
		}
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	public static void main(String[] args) {
		String[] aArray = new String[5];
		aArray[0]= "a";
		testFor();
	}
}
