package com.designpatterns.observer.java;

import java.util.Observable;

/**
 * @description: 气象站（可观察者）
 * @author: mustang
 * @create: 2019-01-06
 **/
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    public WeatherData(){
    }

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity){
        this.temperature=temperature;
        this.humidity=humidity;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }
}
