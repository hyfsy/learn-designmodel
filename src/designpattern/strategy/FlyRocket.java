package designpattern.strategy;

/**
 * 具体行为（算法）
 */
public class FlyRocket implements Fly {
    @Override
    public void fly() {
        System.out.println("火箭般飞翔");
    }
}
