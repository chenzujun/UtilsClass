package com.designpatterns.observer.original;


/**
 * @description: 观察者模式测试类
 * @author: mustang
 * @create: 2019-01-06
 **/
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        ThirdPartyDisplay display = new ThirdPartyDisplay();
        weatherData.registerObserver(display);
        weatherData.setMeasurements(88, 12);
        weatherData.removeObserver(display);
        weatherData.setMeasurements(100, 12);
    }
}
