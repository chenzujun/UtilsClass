package com.designpatterns.factory;

import java.util.Scanner;

/**
 * @description: 披萨店
 * @author: mustang
 * @create: 2018-12-29
 **/
public class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza= factory.createPizza(type);
        return pizza;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择披萨大小：\"cheese\"、\"tomato\"、\"\"（默认）：");
        String type =sc.nextLine();
        Pizza pizza;
        if("cheese".equals(type)){
            pizza = new CheesePizza();
        }else if ("tomato".equals(type)){
            pizza = new TomatoPizza();
        }else {
            pizza = new StandardPizza();
        }
        pizza.createPizza();
    }
}
