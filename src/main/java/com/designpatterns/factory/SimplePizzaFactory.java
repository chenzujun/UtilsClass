package com.designpatterns.factory;

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

    public Pizza createPizza(String style, String type){
        Pizza pizza = null;
        if(style.equals("GD")){
            if("cheese".equals(type)){
                pizza = new GDStyleCheesePizza();
            }else if ("tomato".equals(type)){
                pizza = new GDStyleTomatoPizza();
            }
        }else if(style.equals("HN")){
            if("cheese".equals(type)){
                pizza = new HNStyleCheesePizza();
            }else if ("tomato".equals(type)){
                pizza = new HNStyleTomatoPizza();
            }
        }else {
            return null;
        }
        return pizza;
    }
}
