package com.designpatterns.decorator;

/**
 * @description: 无咖啡因咖啡
 * @author: mustang
 * @create: 2019-01-06
 **/
public class Decaf extends AbstractBeverage {
    public Decaf() {
        description = "无咖啡因咖啡";
    }

    @Override
    public double cost() {
        return 10;
    }
}
