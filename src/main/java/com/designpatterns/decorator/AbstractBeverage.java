package com.designpatterns.decorator;

/**
 * @description: 饮料
 * @author: mustang
 * @create: 2019-01-06
 **/
public abstract class AbstractBeverage {
    String description = "unknown beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
