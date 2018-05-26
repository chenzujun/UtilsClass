package com.java8.service;

public interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }
}
