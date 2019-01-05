package com.designpatterns.strategy;

/**
 * @description: 不会飞
 * @author: mustang
 * @create: 2019-01-06
 **/
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
