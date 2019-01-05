package com.designpatterns.observer.original;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 气象站
 * @author: mustang
 * @create: 2019-01-06
 **/
public class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private List<Observer> observerList;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o:observerList) {
            o.update(temperature,humidity);
        }
    }

    public void setMeasurements(float temperature, float humidity){
        this.temperature=temperature;
        this.humidity=humidity;
        notifyObserver();
    }
}
