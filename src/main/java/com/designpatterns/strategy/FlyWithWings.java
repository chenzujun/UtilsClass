package com.designpatterns.strategy;

/**
 * @description: 用翅膀飞
 * @author: mustang
 * @create: 2019-01-06
 **/
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("煽动翅膀飞行！");
    }
}
