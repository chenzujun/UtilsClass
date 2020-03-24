package com.java8;

/**
 * @description:
 * @author: mustang
 * @create: 2018-06-14
 **/
public class OverridableImpl implements Defaultable {
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }

    static void staticTest() {
        System.out.println("Overridden staticTest");
    }
}
