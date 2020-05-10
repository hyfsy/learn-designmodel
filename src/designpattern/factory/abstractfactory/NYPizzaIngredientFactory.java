package designpattern.factory.abstractfactory;

import designpattern.factory.bean.ingredient.*;

/**
 * 具体纽约原料工厂
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    /**
     * 获取纽约独有的面饼
     */
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    /**
     * 获取纽约独特的酱料
     */
    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    /**
     * 获取纽约本地的蔬菜
     */
    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {
                //大蒜-洋葱-蘑菇-红辣椒
                new Garlic(), new Onion(), new Mushroom(), new RedPapper()
        };
        return veggies;
    }
}
