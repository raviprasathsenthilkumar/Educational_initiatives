package com.designpatterns.behavioral.observer;

/**
 * Concrete Observer - LED Screen Display
 * Displays only temperature (simplified display)
 */
public class LEDScreenDisplay implements Observer, DisplayElement {
    private float temperature;
    private Subject weatherStation;
    
    public LEDScreenDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.attach(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        display();
    }
    
    @Override
    public void display() {
        System.out.println("  💡 LED Screen: " + temperature + "°C");
    }
    
    public void unsubscribe() {
        weatherStation.detach(this);
    }
}