package designpattern.decorator;

/**
 * 装饰者-奶泡
 */
public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with whip";
    }

    @Override
    public double cost() {
        return super.cost() + .10;
    }

}
