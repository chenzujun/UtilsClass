package com.designpatterns.strategy;

/**
 * @description:
 * @author: mustang
 * @create: 2019-01-06
 **/
public class Client {
    public static void main(String[] args) {
        Duck duck = new DecoyDuck();
        duck.setFlyBehavior(new FlyWithWings());
        duck.flyBehavior.fly();
    }
}
