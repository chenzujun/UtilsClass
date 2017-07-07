package com.common.util;

import java.lang.reflect.Method;

import com.bean.User;

public class ClassUtil {

    public static void main(String[] args) throws ClassNotFoundException {
        User a = new User();
        a.setName("jack");

        System.out.println(getFieldValueByName("name", a));

    }

    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}
