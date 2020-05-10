package designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体观察者
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private Observable observable;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionDisplay(Observable o) {
        this.observable = o;
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
             WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }


    @Override
    public void display() {
        System.out.println("温度：" + temperature + "\t湿度：" + humidity + "\t气压：" + pressure);
    }

}
