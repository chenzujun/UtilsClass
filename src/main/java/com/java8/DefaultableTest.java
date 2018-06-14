package com.java8;

/**
 * @description:
 * @author: mustang
 * @create: 2018-06-14
 **/
public class DefaultableTest {
    public static void main(String[] args) {
        Defaultable df = DefaultableFactory.create(DefaultableImpl::new);
        System.out.println(df.notRequired());

        df = DefaultableFactory.create(OverridableImpl::new);
        System.out.println(df.notRequired());

        Defaultable.staticTest();
        OverridableImpl.staticTest();
    }
}
