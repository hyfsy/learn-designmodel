package designpattern.compound;

/**
 * 创建可以计算叫的总数的鸭子工厂类
 */
public class CountDuckFactory extends AbstractDuckFacotry {

    @Override
    public Quackable getMallardDuck() {
        return new QuackWithCount(new MallardDuck());
    }

    @Override
    public Quackable getRedHeadDuck() {
        return new QuackWithCount(new RedHeadDuck());
    }

    @Override
    public Quackable getDuckCall() {
        return new QuackWithCount(new DuckCall());
    }

    @Override
    public Quackable getRubberDuck() {
        return new QuackWithCount(new RubberDuck());
    }

}
