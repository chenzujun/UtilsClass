package com.designpatterns.factory;

/**
 * @description: cheese披萨
 * @author: mustang
 * @create: 2018-12-29
 **/
public class HNStyleCheesePizza implements Pizza {
    @Override
    public void createPizza() {
        System.out.println("cheese pizza");
    }

    @Override
    public Pizza orderPizza() {
        return new HNStyleCheesePizza();
    }

    @Override
    public void prepare() {

    }

    @Override
    public void bake() {

    }

    @Override
    public void cut() {

    }

    @Override
    public void box() {

    }
}
