package com.designpatterns.behavioral.observer;

/**
 * Concrete Observer - Statistics Display
 * Demonstrates extensibility of observer pattern
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float tempSum = 0.0f;
    private int numReadings = 0;
    private Subject weatherStation;
    
    public StatisticsDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.attach(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;
        
        if (temperature > maxTemp) {
            maxTemp = temperature;
        }
        
        if (temperature < minTemp) {
            minTemp = temperature;
        }
        
        display();
    }
    
    @Override
    public void display() {
        float avgTemp = numReadings > 0 ? tempSum / numReadings : 0;
        System.out.println("  📊 Statistics: Avg: " + String.format("%.1f", avgTemp) + 
                         "°C, Max: " + maxTemp + "°C, Min: " + minTemp + "°C");
    }
    
    public void unsubscribe() {
        weatherStation.detach(this);
    }
    
    public float getAverageTemperature() {
        return numReadings > 0 ? tempSum / numReadings : 0;
    }
    
    public float getMaxTemperature() {
        return maxTemp;
    }
    
    public float getMinTemperature() {
        return minTemp;
    }
}