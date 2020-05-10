package designpattern.compound;

/**
 * 鸭鸣器实体类
 */
public class DuckCall implements Quackable {

    private DuckObservable duckObservable;

    public DuckCall(){
        //将鸭子实体注册给鸭子被观察者（辅助类）
        duckObservable = new DuckObservable(this);
    }

    @Override
    public void quack() {
        System.out.println("qwak");
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
