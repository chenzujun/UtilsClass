package com.grammar.collection.mapdemo;

import java.util.HashMap;

/**
 * @description:
 * @author: mustang
 * @create: 2018-04-23
 **/
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>(5);
        map.put(null,"1");
        map.put(null,"2");
        System.out.println(map.size());

    }
}
