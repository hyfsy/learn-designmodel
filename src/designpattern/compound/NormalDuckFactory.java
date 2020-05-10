package designpattern.compound;

/**
 * 创建普通鸭子的工厂
 */
public class NormalDuckFactory extends AbstractDuckFacotry {

    @Override
    public Quackable getMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable getRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    public Quackable getDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable getRubberDuck() {
        return new RubberDuck();
    }

}
