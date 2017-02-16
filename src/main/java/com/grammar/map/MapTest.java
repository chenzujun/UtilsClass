package com.grammar.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
public class MapTest {
	public static void main(String[] args) {
		   List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
	        for (int i = 0; i < 5; i++) { 
	        	Map map1 = new HashMap();
	            map1.put("name", i+"a"); 
	            map1.put("value1", i*10);
	            list1.add(map1);
	        }  
	        
	        List<Map<String, Object>> list2 = new ArrayList<Map<String,Object>>();
	     
	        for (int i = 3; i < 6; i++) {
	        	Map map2 = new HashMap();  
	        	 map2.put("name", i+"a");
	        	 map2.put("value2", i*20);
	        	 list2.add(map2);
	        }  
	          
	        for (Map<String, Object> m : list1) {
				String name = m.get("name")==null?"":m.get("name").toString();
				
				for (Map<String, Object> m2 : list2) {
					String nameother = m2.get("name")==null?"":m2.get("name").toString();
					
					if(name.equals(nameother)){
						m.putAll(m2);
						list2.remove(m2);//删除已合并
						break;
					}
				}
			}
	        
	        Map<String, String> map = new HashMap<String, String>();
	        map.put("1", "a");
	        map.put("2", "b");
	        map.put("3", "C");
	        map.put("4", "d");
	        for (Entry<String, String> t : map.entrySet()) {
				System.out.println(t.getKey()+"=="+t.getValue());
			}
	}
}
