package com.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject - Weather Station
 * Maintains state and notifies observers of changes
 */
public class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherStation() {
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("  [Observer attached: " + observer.getClass().getSimpleName() + "]");
        }
    }
    
    @Override
    public void detach(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("  [Observer detached: " + observer.getClass().getSimpleName() + "]");
        }
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        System.out.println("\n[Weather Station: New measurements received]");
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    
    private void measurementsChanged() {
        notifyObservers();
    }
    
    public float getTemperature() {
        return temperature;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
    
    public int getObserverCount() {
        return observers.size();
    }
}