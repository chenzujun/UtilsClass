package com.designpatterns.observer.java;

/**
 * @description: java自带观察者模式测试类
 * @author: mustang
 * @create: 2019-01-06
 **/
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(82, 12);
    }
}
