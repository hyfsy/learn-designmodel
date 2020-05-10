package designpattern.compound;

public class RedHeadDuck implements Quackable {

    private DuckObservable duckObservable;

    public RedHeadDuck() {
        //将鸭子实体注册给鸭子被观察者（辅助类）
        duckObservable = new DuckObservable(this);
    }

    @Override
    public void quack() {
        System.out.println("red gua");
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
