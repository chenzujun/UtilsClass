package com.grammar.collection.map;

import com.bean.Animal;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class MapTest {

    /**
     * map 遍历方法
     */
    public static void mapTraversal(){
        HashMap<String, String> map = new HashMap();
        map.put("aa", "@sohu.com");
        map.put("bb", "@163.com");
        map.put("cc", "@sina.com");

        // java8
        map.forEach((key, value) ->System.out.println("Key = " + key + "  " + " Value = " + value));
        // forEach
        for (Entry<String, String> entry: map.entrySet()){
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        // 键值分开遍历
        for (String key : map.keySet()) {
            System.out.println("Key = " + key);
        }
        for (String value : map.values()) {
            System.out.println("Value = " + value);
        }
        // 迭代器
        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }

    /**
     * map 排序
     */
    public static void mapSort(){
        Map<String, Animal> map = new HashMap<>();
        map.put("1", new Animal("zhangsan", 17));
        map.put("2", new Animal("lisi", 10));
        map.put("3", new Animal("wangwu", 20));
        map.put("4", new Animal("zhaoliu", 19));

        Map<String, Animal> linkedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Entry.comparingByValue(comparingInt(Animal::getAge)))
                .forEach(entry -> linkedMap.put(entry.getKey(), entry.getValue()));
        linkedMap.forEach((key, value) -> System.out.println("linkedMap key: " + key + ", value:" + value));

        map = map.entrySet().stream()
                .sorted(Entry.comparingByValue(comparingInt(Animal::getAge)))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        map.forEach((key, value) -> System.out.println("用linked map覆盖原map key: " + key + ", value:" + value));
    }

    public static void main(String[] args) {
//        MapTest.mapTraversal();
//        MapTest.mapSort();

        Hashtable s = new Hashtable();
        s.put("1", "2");
        Map<String, Animal> map = new HashMap<>();
        map.put(null,null);
        System.out.println(s.size()+" | "+map.size());
    }
}
