package com.designpatterns.strategy;

/**
 * @description: 鸭子
 * @author: mustang
 * @create: 2019-01-06
 **/
public class Duck {
    String name;
    String color;
    FlyBehavior flyBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
