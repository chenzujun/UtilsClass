package com.designpatterns.factory.pattern;

/**
 * @description: 抽象工厂接口
 *      提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体的类
 * @author: mustang
 * @create: 2019-01-06
 **/
public interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}
