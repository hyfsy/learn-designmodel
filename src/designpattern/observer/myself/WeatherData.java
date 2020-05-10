package designpattern.observer.myself;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题类
 * 天气数据类，检测到变化后自动更新每个布告板
 */
public class WeatherData implements Subject {

    /**
     * 管理观察者列表
     */
    List<Observer> observers;

    /**
     * 温度
     */
    private float temperature;

    /**
     * 湿度
     */
    private float humidity;

    /**
     * 气压
     */
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void addSubject(Observer o) {

        //添加观察者
        observers.add(o);

    }

    @Override
    public void removeSubject(Observer o) {
        int index = observers.indexOf(o);
        if (index >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void performSubject() {

        //遍历列表通知观察者
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    /**
     * 此处可设置改变状态
     */
    public void measurementChanged(){
        //当值改变后，通知所有的观察者
        performSubject();
    }

    public void setMeasurement(float temperature, float humidity, float pressure) {
        this.setTemperature(temperature);
        this.setHumidity(humidity);
        this.setPressure(pressure);
        measurementChanged();
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
