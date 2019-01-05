package com.designpatterns.factory.method;


/**
 * @description: 具体的Pizza店
 * @author: mustang
 * @create: 2019-01-06
 **/
public class HNPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if("cheese".equals(type)){
            return new HNStyleCheesePizza();
        }else if("tomato".equals(type)){
            return new HNStyleTomatoPizza();
        }
        return null;
    }
}
