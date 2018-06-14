package com.java8;

import java.util.function.Supplier;

public interface Defaultable {
    /**
     * @return
     */
    default String notRequired() {
        return "Default implementation";
    }

    static void staticTest() {
        System.out.println("staticTest");
    }
}
