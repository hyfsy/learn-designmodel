package designpattern.compound;

/**
 * 野鸭实体类
 */
public class MallardDuck implements Quackable {

    private DuckObservable duckObservable;

    public MallardDuck(){
        //将鸭子实体注册给鸭子被观察者（辅助类）
        duckObservable = new DuckObservable(this);
    }

    @Override
    public void quack() {
        System.out.println("gua gua");
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
