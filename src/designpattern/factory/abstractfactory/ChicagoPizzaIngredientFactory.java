package designpattern.factory.abstractfactory;

import designpattern.factory.bean.ingredient.*;

/**
 * 具体芝加哥原料工厂
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    /**
     * 获取芝加哥独有的面饼
     */
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    /**
     * 获取芝加哥独特的酱料
     */
    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    /**
     * 获取芝加哥本地的蔬菜
     */
    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new BlackOlives(), new Spinach(), new Eggplant()};
        return veggies;
    }
}
