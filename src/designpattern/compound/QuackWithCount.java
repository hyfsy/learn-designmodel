package designpattern.compound;

/**
 * 装饰类-计数鹅叫，实现统一接口（装饰者）
 */
public class QuackWithCount implements Quackable {

    private Quackable quackable;
    /**
     * 将计数设置为静态，全局统一
     */
    private static int count = 0;

    public QuackWithCount(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        quackable.quack();
        count++;
        //装饰者也需要通知观察者
    }

    /**
     * 获取鸭子叫的总数
     * 设置为静态方法
     */
    public static int getCount() {
        return count;
    }

    /**
     * 让装饰的对象去执行操作
     */
    @Override
    public void registerObserver(QuackObserver observer) {
        quackable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        quackable.notifyObservers();
    }

}
