package com.designpatterns.factory.pattern;

/**
 * @description: 抽象工厂测试类
 * @author: mustang
 * @create: 2019-01-06
 **/
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        factory1.createProductA();
        factory1.createProductB();

        AbstractFactory factory2 = new ConcreteFactory2();
        factory2.createProductA();
        factory2.createProductB();
    }
}
