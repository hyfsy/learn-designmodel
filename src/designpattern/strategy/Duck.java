package designpattern.strategy;

/**
 * 鸭子抽象类
 */
public abstract class Duck {

    /**
     * 将会改变的行为抽出去
     */
    private Fly flyBehavior;

    private  Quack quackBehavior;

    /**
     * 每个鸭子都有的行为
     */
    public void swim(){
        System.out.println("游泳");
    }

    /**
     * 鸭子不同的展示
     */
    public abstract void display();

    /**
     * 传入对应行为对象，执行对应行为
     * @param flyBehavior
     */
    public void setFlyBehavior(Fly flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(Quack quackBehavior){
        this.quackBehavior = quackBehavior;
    }

    /**
     * 执行飞方法
     */
    public void performFly(){
        flyBehavior.fly();
    }

    /**
     * 执行叫方法
     */
    public void performQuack(){
        quackBehavior.quack();
    }

}
