package designpattern.compound;

/**
 * 鹅叫的适配器，让鹅能假装鸭叫（适配器）
 */
public class WhiteGooseAdapter implements Quackable {

    private DuckObservable duckObservable;

    private GooseQuack gooseQuack;

    public WhiteGooseAdapter(GooseQuack gooseQuack){
        this.gooseQuack = gooseQuack;
        //将鸭子实体注册给鸭子被观察者（辅助类）
        duckObservable = new DuckObservable(this);
    }

    @Override
    public void quack() {
        gooseQuack.honk();
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
