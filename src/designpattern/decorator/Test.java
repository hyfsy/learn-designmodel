package designpattern.decorator;

/**
 * 装饰者模式
 * 动态地将责任附加到对象上。若要扩展功能,装饰者提供了比继承更有弹性的替代方案
 */
public class Test {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        beverage = new Milk(beverage);
        beverage = new Soy(beverage);
        beverage = new Whip(beverage);
        System.out.println("商品：" + beverage.getDescription() + "\n共花费：$" + beverage.cost());
    }
}
