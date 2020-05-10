package designpattern.factory.simplefactory;

/**
 * 简单工厂并不算设计模式
 * 只能获荣誉奖
 */
public class Test {
    public static void main(String[] args) {
        PizzaFactory factory = new PizzaFactory();
        PizzaStore store = new PizzaStore(factory);
        store.orderPizza("clam");
    }
}
