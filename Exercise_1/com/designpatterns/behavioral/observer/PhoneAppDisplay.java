package com.designpatterns.behavioral.observer;

/**
 * Concrete Observer - Phone App Display
 */
public class PhoneAppDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherStation;
    
    public PhoneAppDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.attach(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    
    @Override
    public void display() {
        System.out.println("  📱 Phone App: Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
    }
    
    public void unsubscribe() {
        weatherStation.detach(this);
    }
}