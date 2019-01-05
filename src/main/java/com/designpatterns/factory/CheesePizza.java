package com.designpatterns.factory;

/**
 * @description: cheese披萨
 * @author: mustang
 * @create: 2018-12-29
 **/
public class CheesePizza implements Pizza {
    @Override
    public void createPizza() {
        System.out.println("cheese pizza");
    }

    @Override
    public Pizza orderPizza() {
        return new CheesePizza();
    }

}
