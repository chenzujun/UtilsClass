package com.designpatterns.factory;

/**
 * @description: 标准披萨
 * @author: mustang
 * @create: 2018-12-29
 **/
public class StandardPizza implements Pizza {
    @Override
    public void createPizza() {
        System.out.println("standard pizza");
    }

    @Override
    public Pizza orderPizza() {
        return new StandardPizza();
    }
}
