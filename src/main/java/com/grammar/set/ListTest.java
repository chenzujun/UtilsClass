package com.grammar.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
//		for (Integer in : list) {
//			if(22 == in){
//				list.remove(in);
//			}
//			System.out.println(in);
//		}
//		for (Integer integer : list) {
////			System.out.println(integer);
//		}
		
		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
            int in = (Integer) iter.next();
            if(22 == in){
            	iter.remove();
			}
			System.out.println(in);
        }
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
	}
	
	public static void testSetRemove(){
		Set<Integer> set = new HashSet<Integer>();
		set.add(new Integer(1));
		set.add(new Integer(22));
		set.add(new Integer(333));

//		for (Integer integer : set) {
//			if(22 == integer){
//				set.remove(integer);
//			}
//		}
		for (Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
            int in = (Integer) iter.next();
            if(22 == in){
            	iter.remove();
			}
			System.out.println(in);
        }
		
		for (Integer integer : set) {
			System.out.println(integer);
		}
	}
	
	public static void main(String[] args) {
		testSetRemove();
	}
}
