package com.designpatterns.factory.pattern;

/**
 * @description: 抽象工厂接口
 * @author: mustang
 * @create: 2019-01-06
 **/
public interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}
