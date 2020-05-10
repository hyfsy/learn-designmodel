package designpattern.decorator;

/**
 * 装饰者-豆浆
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with soy";
    }

    @Override
    public double cost() {
        return super.cost() + .15;
    }

}
