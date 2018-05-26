package com.java8;

import com.java8.service.PropertySource;
import com.java8.service.PropertySource8;
import com.java8.service.PropertySources;
import com.java8.service.PropertySources8;

/**
 * @description: 重复注解
 * @author: mustang
 * @create: 2018-05-26
 **/
@PropertySource8("classpath:config8.properties")
@PropertySource8("file:application8.properties")
public class RepeateAnnotations8 {
    public static void main(String[] args) {
        PropertySources annotation = RepeateAnnotations.class.getAnnotation(PropertySources.class);
        for (PropertySource propertySource: annotation.value()){
            System.out.println(propertySource.value());
        }

        PropertySources8 annotation8 = RepeateAnnotations8.class.getAnnotation(PropertySources8.class);
        for (PropertySource8 propertySource8: annotation8.value()){
            System.out.println(propertySource8.value());
        }
    }
}
