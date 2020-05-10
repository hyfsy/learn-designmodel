package designpattern.factory.factorymethod;


import designpattern.factory.abstractfactory.PizzaIngredientFactory;
import designpattern.factory.bean.pizza.Pizza;
import designpattern.factory.bean.pizza.ChicagoCheesePizza;
import designpattern.factory.bean.pizza.ChicagoClamPizza;
import designpattern.factory.bean.pizza.ChicagoPepperoniPizza;
import designpattern.factory.bean.pizza.ChicagoVeggiePizza;

/**
 * 工厂方法子类，实现具体的 pizza
 * 创建芝加哥风味 pizza
 */
public class ChicagoPizzaStore extends PizzaStore {

    private Pizza pizza = null;

    private PizzaIngredientFactory ingredientFactory;

    public ChicagoPizzaStore(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * 创建芝加哥地区风味对应类型的 pizza
     *
     * @param type pizza 类型
     * @return pizza 对象
     */
    @Override
    public Pizza createPizza(String type) {
        //芝士 pizza
        if ("cheese".equals(type)) {
            pizza = new ChicagoCheesePizza(ingredientFactory);
            pizza.setName("ChicagoCheesePizza");
        }
        //蛤俐 pizza
        else if ("clam".equals(type)) {
            pizza = new ChicagoClamPizza(ingredientFactory);
            pizza.setName("ChicagoClamPizza");
        }
        //素食 pizza
        else if ("veggie".equals(type)) {
            pizza = new ChicagoVeggiePizza(ingredientFactory);
            pizza.setName("ChicagoVeggiePizza");
        }
        //意大利辣香肠 pizza
        else if ("pepperoni".equals(type)) {
            pizza = new ChicagoPepperoniPizza(ingredientFactory);
            pizza.setName("ChicagoPepperoniPizza");
        }
        return pizza;
    }
}
