package com.java8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @description: 数组+链表+红黑树（1.8增加）
 * @author: mustang
 * @create: 2018-06-05
 **/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put("aa", "@sohu.com");
        map.put("bb", "@163.com");
        map.put("cc", "@sina.com");

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }
}
