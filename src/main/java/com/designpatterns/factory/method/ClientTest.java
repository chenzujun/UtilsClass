package com.designpatterns.factory.method;

/**
 * @description: 测试工厂方法模式
 * @author: mustang
 * @create: 2019-01-06
 **/
public class ClientTest {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new HNPizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}
