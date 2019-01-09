package com.designpatterns.decorator;

/**
 * @description: 装饰者模式测试类
 * @author: mustang
 * @create: 2019-01-06
 **/
public class Client {
    public static void main(String[] args) {
        AbstractBeverage beverage = new Decaf();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        AbstractBeverage beverage2 = new Decaf();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
    }
}
