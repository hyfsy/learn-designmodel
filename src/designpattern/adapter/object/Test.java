package designpattern.adapter.object;

/**
 * 适配器模式
 * 适配器模式将一个类的接口,转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间
 *
 * 与外观模式的区别：
 *      外观和适配器可以包装许多类,但是外观的意图是简化接口,而适配器的意图是将接口转换成不同接口
 */
public class Test {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        turkey.gobble();
        turkey.fly();

        Duck duck = new MallardDuck();
        duck.quack();
        duck.fly();

        //定义火鸡适配器 用来适配鸭子
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        turkeyAdapter.fly();
        turkeyAdapter.quack();
    }
}
