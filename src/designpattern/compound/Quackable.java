package designpattern.compound;

/**
 * 可以叫的接口（扩展成被观察鸭子）
 */
public interface Quackable extends QuackObservable {

    void quack();

}
