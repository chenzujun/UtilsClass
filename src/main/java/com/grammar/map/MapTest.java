package com.grammar.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer, String> value = new HashMap<Integer, String>();
//		value.put(null, "fa");
//		value.put(null, "f2a");
		value.put(1, null);
		value.put(2, null);
		for (Map.Entry<Integer, String> m : value.entrySet()) {
			System.out.println(m.getKey()+"="+m.getValue());
		}
	}
}
