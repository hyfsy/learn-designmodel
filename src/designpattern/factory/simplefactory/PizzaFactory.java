package designpattern.factory.simplefactory;

import designpattern.factory.bean.simple.*;

/**
 * 创建披萨的简单工厂
 */
public class PizzaFactory {


    public Pizza createPizza(String type){
        Pizza pizza = null;

        if("cheese".equals(type)){
            pizza = new CheesePizza();
            pizza.setName("CheesePizza");
        }else if("clam".equals(type)){
            pizza = new ClamPizza();
            pizza.setName("ClamPizza");
        }else if("viggie".equals(type)){
            pizza = new ViggiePizza();
            pizza.setName("ViggiePizza");
        }else if("pepperoni".equals(type)){
            pizza  = new PepperoniPizza();
            pizza.setName("PepperoniPizza");
        }

        return pizza;
    }
}
