package designpattern.templatemethod;

/**
 * 咖啡
 */
public class Coffee extends CaffeineBeverage {

    @Override
    public void addCondiments() {
        System.out.println("添加糖和牛奶");
    }

    @Override
    public void brew() {
        System.out.println("开始泡咖啡");
    }
}
