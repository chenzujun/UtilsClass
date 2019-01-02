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
