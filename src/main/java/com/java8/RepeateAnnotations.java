package com.java8;

import com.java8.service.PropertySource;
import com.java8.service.PropertySources;
import com.java8.service.PropertySources8;

/**
 * @description: Java 8 之前重复使用注解
 * @author: mustang
 * @create: 2018-05-26
 **/
@PropertySources({
        @PropertySource("classpath:config.properties"),
        @PropertySource("file:application.properties")
})
public class RepeateAnnotations {

    public static void main(String[] args) {
    }
}
