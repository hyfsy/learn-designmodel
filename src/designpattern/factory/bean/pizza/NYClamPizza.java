package designpattern.factory.bean.pizza;

import designpattern.factory.abstractfactory.PizzaIngredientFactory;

public class NYClamPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public NYClamPizza() {
    }

    public NYClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("prepare pizza " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        veggies = ingredientFactory.createVeggies();
    }
}
