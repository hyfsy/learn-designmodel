package designpattern.compound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 鸭子群（组合+迭代器）
 */
public class Flock implements Quackable {

    private List<Quackable> quackerList = new ArrayList<>();

    private DuckObservable duckObservable;

    public Flock() {
        //将鸭子群实体注册给鸭子被观察者（辅助类）
        duckObservable = new DuckObservable(this);
    }

    public void add(Quackable quacker) {
        quackerList.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackerList.iterator();
        while (iterator.hasNext()) {
            //管理鸭群，让每一只鸭子都开始叫
            iterator.next().quack();
        }
    }

    /**
     * 让群内的每个鸭子注册观察者
     */
    @Override
    public void registerObserver(QuackObserver observer) {
        Iterator<Quackable> iterator = quackerList.iterator();
        while (iterator.hasNext()) {
            iterator.next().registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        duckObservable.notifyObservers();
    }

}
