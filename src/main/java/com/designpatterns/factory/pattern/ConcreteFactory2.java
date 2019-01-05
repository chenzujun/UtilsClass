package com.designpatterns.factory.pattern;

/**
 * @description: 2号工厂
 * @author: mustang
 * @create: 2019-01-06
 **/
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
