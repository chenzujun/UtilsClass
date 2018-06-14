package com.java8;

import java.util.function.Supplier;

/**
 * @description:
 * @author: mustang
 * @create: 2018-06-14
 **/
public interface DefaultableFactory {
    /**
     * Interfaces now allow static methods
     *
     * @param supplier
     * @return
     */
    static Defaultable create(Supplier<Defaultable> supplier) {
        return supplier.get();
    }
}
