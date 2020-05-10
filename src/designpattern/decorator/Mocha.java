package designpattern.decorator;

/**
 * 装饰者-摩卡
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with mocha";
    }

    @Override
    public double cost() {
        return super.cost() + .20;
    }

}
