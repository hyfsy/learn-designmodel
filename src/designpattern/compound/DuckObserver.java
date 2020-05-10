package designpattern.compound;

/**
 * 鸭子叫的观察者对象
 */
public class DuckObserver implements QuackObserver {

    @Override
    public void update(QuackObservable quackObservable) {
        System.out.println(quackObservable.getClass().getSimpleName() + " is quacked , it want you know");
    }

}
