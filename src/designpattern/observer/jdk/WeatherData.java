package designpattern.observer.jdk;

import java.util.Observable;

/**
 * 具体可观察者
 */
public class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurement(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public void measurementChanged(){
        //改变状态，让主题通知观察者
        setChanged();
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
