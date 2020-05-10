package designpattern.compound;

/**
 * 橡皮鸭实体类
 */
public class RubberDuck implements Quackable {

    private DuckObservable duckObservable;

    public RubberDuck(){
        //将鸭子实体注册给鸭子被观察者（辅助类）
        duckObservable = new DuckObservable(this);
    }

    @Override
    public void quack() {
        System.out.println("qi qi qi...");
        notifyObservers();
    }

    @Override
    public void registerObserver(QuackObserver observer) {
        duckObservable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duckObservable.notifyObservers();
    }

}
