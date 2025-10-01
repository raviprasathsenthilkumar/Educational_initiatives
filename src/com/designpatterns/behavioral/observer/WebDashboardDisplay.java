package com.designpatterns.behavioral.observer;

/**
 * Concrete Observer - Web Dashboard Display
 */
public class WebDashboardDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherStation;
    
    public WebDashboardDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.attach(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
    
    @Override
    public void display() {
        System.out.println("  🌐 Web Dashboard: Temp: " + temperature + "°C, " +
                         "Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
    
    public void unsubscribe() {
        weatherStation.detach(this);
    }
}