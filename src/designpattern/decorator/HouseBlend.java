package designpattern.decorator;

/**
 * 被装饰者-综合咖啡
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
