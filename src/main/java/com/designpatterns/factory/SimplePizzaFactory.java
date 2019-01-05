package com.designpatterns.factory;

import com.designpatterns.factory.method.GDStyleCheesePizza;
import com.designpatterns.factory.method.GDStyleTomatoPizza;
import com.designpatterns.factory.method.HNStyleCheesePizza;
import com.designpatterns.factory.method.HNStyleTomatoPizza;

/**
 * @description: 简单工厂
 * @author: mustang
 * @create: 2018-12-30
 **/
public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if("cheese".equals(type)){
            pizza = new CheesePizza();
        }else if ("tomato".equals(type)){
            pizza = new TomatoPizza();
        }
        return pizza;
    }
}
