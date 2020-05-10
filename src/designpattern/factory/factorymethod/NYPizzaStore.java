package designpattern.factory.factorymethod;

import designpattern.factory.abstractfactory.PizzaIngredientFactory;
import designpattern.factory.bean.pizza.Pizza;
import designpattern.factory.bean.pizza.NYCheesePizza;
import designpattern.factory.bean.pizza.NYClamPizza;
import designpattern.factory.bean.pizza.NYPepperoniPizza;
import designpattern.factory.bean.pizza.NYVeggiePizza;

/**
 * 工厂方法子类，实现具体的 pizza
 * 创建纽约风味 pizza
 */
public class NYPizzaStore extends PizzaStore {

    private Pizza pizza = null;

    private PizzaIngredientFactory ingredientFactory;

    public NYPizzaStore(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * 创建纽约地区风味对应类型的 pizza
     *
     * @param type pizza 类型
     * @return pizza 对象
     */
    @Override
    public Pizza createPizza(String type) {
        //芝士 pizza
        if ("cheese".equals(type)) {
            pizza = new NYCheesePizza(ingredientFactory);
            pizza.setName("NYCheesePizza");
        }
        //蛤俐 pizza
        else if ("clam".equals(type)) {
            pizza = new NYClamPizza(ingredientFactory);
            pizza.setName("NYClamPizza");
        }
        //素食 pizza
        else if ("veggie".equals(type)) {
            pizza = new NYVeggiePizza(ingredientFactory);
            pizza.setName("NYVeggiePizza");
        }
        //意大利辣香肠 pizza
        else if ("pepperoni".equals(type)) {
            pizza = new NYPepperoniPizza(ingredientFactory);
            pizza.setName("NYPepperoniPizza");
        }
        return pizza;
    }

}
