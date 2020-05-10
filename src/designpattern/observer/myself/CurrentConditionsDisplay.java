package designpattern.observer.myself;

/**
 * 具体观察者
 * 布告板具体实现类
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;

    private float humidity;

    private Subject subject;

    public CurrentConditionsDisplay(Subject subject) {
        this.subject = subject;
        //将自己添加到 对应主题的 观察者集合里
        this.subject.addSubject(this);
    }

    @Override
    public void display() {
        System.out.println("温度：" + temperature + "\t湿度：" + humidity);
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)subject;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
