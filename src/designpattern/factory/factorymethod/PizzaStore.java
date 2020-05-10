package designpattern.factory.factorymethod;

import designpattern.factory.bean.pizza.Pizza;

/**
 * 工厂方法的接口
 */
public abstract class PizzaStore {

    /**
     * pizza对象
     */
    private Pizza pizza = null;

    /**
     * 披萨对象统一的行为
     */
    public Pizza orderPizza(String type) {

        //获取对应 pizza
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println("制作完毕!");
        return pizza;
    }

    /**
     * 抽象方法，子类具体实现
     */
    public abstract Pizza createPizza(String type);

}
