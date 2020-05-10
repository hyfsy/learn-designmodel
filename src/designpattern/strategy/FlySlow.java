package designpattern.strategy;

/**
 * 具体行为（算法）
 */
public class FlySlow implements Fly {
    @Override
    public void fly() {
        System.out.println("慢慢的飞");
    }
}
