package designpattern.factory.abstractfactory;

import designpattern.factory.bean.ingredient.Dough;
import designpattern.factory.bean.ingredient.Sauce;
import designpattern.factory.bean.ingredient.Veggies;

/**
 * 抽象工厂的接口
 */
public interface PizzaIngredientFactory {

    /**
     * 面团
     */
    Dough createDough();

    /**
     * 酱料
     */
    Sauce createSauce();

    /**
     * 多种素食
     */
    Veggies[] createVeggies();
}
