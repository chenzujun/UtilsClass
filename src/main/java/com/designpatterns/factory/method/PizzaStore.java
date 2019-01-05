package com.designpatterns.factory.method;

/**
 * @description: 工厂方法模式
 * @author: mustang
 * @create: 2019-01-06
 **/
public abstract class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return  pizza;
    }
    protected abstract Pizza createPizza(String type);
}
