package com.java8.inference;

/**
 * @description:
 * @author: mustang
 * @create: 2018-05-26
 **/
public class Value< T > {
    public static< T > T defaultValue() {
        return null;
    }

    public T getOrDefault( T value, T defaultValue ) {
        return ( value != null ) ? value : defaultValue;
    }
}
