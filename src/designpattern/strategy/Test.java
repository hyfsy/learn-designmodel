package designpattern.strategy;

/**
 * 策略模式
 * 定义了算法族,分别封装起来,让它们之间可以互相替换,此模式让算法的变化独立于使用算法的客户
 */
public class Test {
    public static void main(String[] args) {
        //声明野鸭子
        Duck duck = new MallardDuck();
        //设置鸭子的火箭飞行能力
        duck.setFlyBehavior(new FlyRocket());
        //设置鸭子的叫声
        duck.setQuackBehavior(new QuackGuagua());
        duck.display();
        duck.performFly();
        duck.performQuack();
    }
}
