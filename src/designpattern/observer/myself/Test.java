package designpattern.observer.myself;

/**
 * 观察者模式
 *  .推（被认为更正确）
 *  .拉
 *
 * 定义了一系列对象之间的一对多关系,当一个对象改变状态,其他依赖者都会收到通知,并自动更新
 *
 * 可改进的地方：主题接口添加状态改变方法，改变状态后才通知观察者
 */
public class Test {
    public static void main(String[] args) {
        //定义具体主题对象
        WeatherData weatherData = new WeatherData();
        //定义具体观察者
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        //主题值改变后，通知观察者
        weatherData.setMeasurement(11,12,134);
        weatherData.setMeasurement(432,23,55);
    }
}
