package designpattern.compound;

/**
 * 鸭子-可观察对象接口（观察者模式）
 */
public interface QuackObservable {

    void registerObserver(QuackObserver observer);

    //此处的remove就不实现了
//    void remoteObserver();

    void notifyObservers();

}
