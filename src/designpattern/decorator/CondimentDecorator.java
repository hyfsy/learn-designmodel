package designpattern.decorator;

/**
 * 调料装饰者组件
 */
public class CondimentDecorator extends Beverage {

    /**
     * 被装饰对象
     */
    private Beverage beverage;

    //构造方法初始化被装饰对象
    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    //也要重写父类的描述方法
    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double cost() {
        return beverage.cost();
    }
}
