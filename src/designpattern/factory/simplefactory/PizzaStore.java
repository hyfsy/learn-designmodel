package designpattern.factory.simplefactory;

import designpattern.factory.bean.simple.Pizza;

public class PizzaStore {

    private Pizza pizza;
    private PizzaFactory factory;

    public PizzaStore(PizzaFactory factory){
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        pizza =factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }


}
