package com.designpatterns.factory;

/**
 * @description: tomato披萨
 * @author: mustang
 * @create: 2018-12-29
 **/
public class TomatoPizza implements Pizza {
    @Override
    public void createPizza() {
        System.out.println("tomato pizza");
    }

    @Override
    public Pizza orderPizza() {
        return null;
    }
}
