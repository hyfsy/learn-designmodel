package designpattern.decorator;

/**
 * 装饰者-牛奶
 */
public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with milk";
    }

    @Override
    public double cost() {
        return super.cost() + .10;
    }
}
