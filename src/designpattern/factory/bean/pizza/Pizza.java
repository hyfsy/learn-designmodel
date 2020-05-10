package designpattern.factory.bean.pizza;

import designpattern.factory.bean.ingredient.Dough;
import designpattern.factory.bean.ingredient.Sauce;
import designpattern.factory.bean.ingredient.Veggies;

import java.util.Arrays;

/**
 * 披萨类
 */
public abstract class Pizza {

    /**
     * 披萨名称
     */
    protected String name = null;

    /**
     * 面团
     */
    protected Dough dough = null;

    /**
     * 酱料
     */
    protected Sauce sauce = null;

    /**
     * 作料
     */
    protected Veggies[] veggies = null;

    /**
     * 准备披萨原料
     */
    public abstract void prepare();

    public void bake() {
        System.out.println("烘烤 20-25 分钟");
    }

    public void cut() {
        System.out.println("开始对角切开");
    }

    public void box() {
        System.out.println("装箱");
    }

    /**
     * 获取 pizza 名称
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", veggies=" + Arrays.toString(veggies) +
                '}';
    }
}
