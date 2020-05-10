package designpattern.strategy;

/**
 * 具体行为（算法）
 */
public class QuackZhazha implements Quack {
    @Override
    public void quack() {
        System.out.println("喳喳叫");
    }
}
