package com.designpatterns.observer.java;

import com.designpatterns.observer.common.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * @description: 显示器（观察者）
 * @author: mustang
 * @create: 2019-01-06
 **/
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("current conditions:"+temperature +"F degrees and "+humidity+"% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
