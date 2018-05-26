package com.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: mustang
 * @create: 2018-05-26
 **/
public class StreamTest {
    public static void main(String[] args) {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");

        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

        List<String> arrList = list.stream().map(String::toUpperCase). collect(Collectors.toList());
        arrList.forEach(System.out::println);

        List<String> parallelArrList = list.parallelStream().map(String::toUpperCase). collect(Collectors.toList());
        parallelArrList.forEach(System.out::println);

        Set<String> set = new HashSet<>();
        set.stream();

    }
}
