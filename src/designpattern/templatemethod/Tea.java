package designpattern.templatemethod;

/**
 * 茶
 */
public class Tea extends CaffeineBeverage {

    /**
     * 重写父类的算法中部分的实现
     */
    @Override
    public void addCondiments() {
        System.out.println("添加柠(ning)檬");
    }

    @Override
    public void brew() {
        System.out.println("开始泡茶");
    }
}
