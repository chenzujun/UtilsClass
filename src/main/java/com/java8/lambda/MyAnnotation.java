package com.java8.lambda;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chenjun
 * @date 2018/6/14
 * @since V1.0.0
 */
@Target(ElementType.TYPE) // 使用范围在类、接口和枚举
@Retention(RetentionPolicy.RUNTIME) // 生命周期在运行时期，可以进行反射操作
public @interface MyAnnotation {
    String value();// 定义一个属性值
}