package designpattern.compound;

import java.util.ArrayList;
import java.util.List;

/**
 * 鸭子叫的被观察者对象
 */
public class DuckObservable implements QuackObservable {

    private List<QuackObserver> observers = new ArrayList<>();
    private QuackObservable quackObservable;

    public DuckObservable(QuackObservable quackObservable) {
        this.quackObservable = quackObservable;
    }

    /**
     * 注册观察对象
     */
    @Override
    public void registerObserver(QuackObserver observer) {
        observers.add(observer);
    }

    /**
     * 通知所有观察对象
     */
    @Override
    public void notifyObservers() {
        for (QuackObserver observer : observers) {
            observer.update(quackObservable);
        }
    }
}
