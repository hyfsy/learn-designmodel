package designpattern.strategy;

/**
 * 具体行为（算法）
 */
public class QuackGuagua implements Quack {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
