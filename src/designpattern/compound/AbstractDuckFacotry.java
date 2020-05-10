package designpattern.compound;

/**
 * 鸭子抽象工厂，创建同一类鸭子的多个品种（抽象工厂）
 */
public abstract class AbstractDuckFacotry {

    public abstract Quackable getMallardDuck();

    public abstract Quackable getRedHeadDuck();

    public abstract Quackable getDuckCall();

    public abstract Quackable getRubberDuck();

}
