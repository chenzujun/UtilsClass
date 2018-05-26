package com.java8.inference;

/**
 * @description:
 * @author: mustang
 * @create: 2018-05-26
 **/
public class TypeInference {
    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        System.out.println(value.getOrDefault("abc",
                Value.defaultValue()));


        System.out.println(value.getOrDefault(null, Value.defaultValue()));
    }
}