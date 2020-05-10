package designpattern.adapter.object;

/**
 * 绿头鸭-实现类
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("gua gua");
    }

    @Override
    public void fly() {
        System.out.println("shoot off fly");
    }
}
