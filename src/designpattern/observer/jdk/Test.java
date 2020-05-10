package designpattern.observer.jdk;

/**
 * java自带观察者模型
 */
public class Test {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay conditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurement(32,45,754);
    }


}
