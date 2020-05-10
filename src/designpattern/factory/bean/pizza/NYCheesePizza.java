package designpattern.factory.bean.pizza;

import designpattern.factory.abstractfactory.PizzaIngredientFactory;

public class NYCheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public NYCheesePizza() {
    }

    public NYCheesePizza(PizzaIngredientFactory ingredientFactory) {
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
