package com.java8;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @description:
 * @author: mustang
 * @create: 2018-05-26
 **/
public class GetRuntimeParameterName {
    public void createUser(String name) {
        System.out.println("创建成功：name=" + name);
    }

    public static void main(String[] args) throws Exception {
        for (Method m : GetRuntimeParameterName.class.getMethods()) {
            System.out.println("----------------------------------------");
            System.out.println("   method: " + m.getName());
            System.out.println("   return: " + m.getReturnType().getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("parameter: " + p.getType().getName() + ", " + p.getName());
            }
        }
    }
}
