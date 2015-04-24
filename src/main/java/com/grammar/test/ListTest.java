package com.grammar.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest
{
    
    
    public static void main(String[] args)
    {
     List<Map<String, String>> list = new ArrayList<Map<String, String>>();
     Map<String, String> map = new HashMap<String, String>();
     map.put("1", "hi");
     list.add(map);
     
     Map<String, String> map2 = new HashMap<String, String>();
     map2.put("2", "hello");
     list.add(map2);
     
     System.out.println(list.toString());
     
    }
}
