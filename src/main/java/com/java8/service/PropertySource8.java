package com.java8.service;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Repeatable：建立了 @PropertySource8 与 @PropertySources8 的关系
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(PropertySources8.class)
public @interface PropertySource8 {
    String value();
}
