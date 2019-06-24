package com.designpatterns.observer.original;

import com.designpatterns.observer.common.DisplayElement;

/**
 * @description: 显示器（观察者）
 * @author: mustang
 * @create: 2019-01-06
 **/
public class ThirdPartyDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;

    @Override
    public void update(float temp, float humidity) {
        this.temperature = temp;
        this.humidity=humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("current conditions:"+temperature +"F degrees and "+humidity+"% humidity");
    }
}
