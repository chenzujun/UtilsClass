package com.designpatterns.factory.pattern;

/**
 * @description: 1号工厂
 * @author: mustang
 * @create: 2019-01-06
 **/
public class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
