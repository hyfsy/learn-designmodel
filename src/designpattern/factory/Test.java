package designpattern.factory;

import designpattern.factory.abstractfactory.NYPizzaIngredientFactory;
import designpattern.factory.factorymethod.NYPizzaStore;
import designpattern.factory.abstractfactory.PizzaIngredientFactory;
import designpattern.factory.factorymethod.PizzaStore;

/**
 * 工厂模式：
 *
 * 工厂方法
 *  .定义了一个创建对象的接口,但由子类决定要实例化的类是哪一个.工厂方法让类把实例化推迟到子类
 * 抽象工厂
 *  .提供一个接口,用于创建相关或依赖对象的家族,而不需要明确指定具体类
 *
 * 依赖倒置原则（让底层组件反过来依赖高层组件的抽象）
 *      1、变量不可以持有具体类的引用
 *      2、不要让类派生自具体类
 *      3、不要覆盖基类中已实现的方法
 *
 * pizza 的地区风味用了工厂方法
 * pizza 的原料用了抽象工厂
 *
 */
public class Test {
    public static void main(String[] args) {

        //创建对应地区的原料工厂
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        //通过对应原料 创建纽约风格的 pizza
        PizzaStore store = new NYPizzaStore(ingredientFactory);
        //订购对应类型的 pizza
        store.orderPizza("clam");

    }
}
