package com.designpatterns.decorator;

/**
 * @description: 摩卡装饰者
 * @author: mustang
 * @create: 2019-01-06
 **/
public class Mocha extends AbstractCondimentDecorator {
    AbstractBeverage beverage;

    public Mocha(AbstractBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 摩卡";
    }

    @Override
    public double cost() {
        return beverage.cost() + 5;
    }
}
