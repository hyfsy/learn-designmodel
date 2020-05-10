package designpattern.adapter.object;

/**
 * 火鸡适配器
 */
public class TurkeyAdapter implements Duck {

    /**
     * 原本的火鸡
     */
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    /**
     * 调用鸭子的叫方法实际上是调用了火鸡的叫方法
     */
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        //火鸡飞行距离短，要飞五次才赶上鸭子
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
