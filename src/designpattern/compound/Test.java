package designpattern.compound;

/**
 * 并非复合模式，只是模式间的相互合作
 */
public class Test {
    public static void main(String[] args) {
        new Test().duckQuack();
    }

    public void duckQuack() {

        //==============================通过鸭子工厂创建鸭子====================================

        //把鸭子装饰起来，叫的时候顺便计算叫的个数
        //工厂方式创建装饰过的鸭子对象
        CountDuckFactory countDuckFactory = new CountDuckFactory();
        Quackable redHeadDuck = countDuckFactory.getRedHeadDuck();
        Quackable duckCall = countDuckFactory.getDuckCall();
        Quackable rubberDuck = countDuckFactory.getRubberDuck();
        // 将鹅适配成鸭子
        // 我们只计数真鸭子的叫，假的鸭子就不计数(装饰)了
        Quackable whiteGoose = new WhiteGooseAdapter(new WhiteGoose());

        //=================================创建两个鸭群=========================================

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(whiteGoose);

        Flock flockOfMallard = new Flock();
        Quackable mallardDuckOne = countDuckFactory.getMallardDuck();
        Quackable mallardDuckTwo = countDuckFactory.getMallardDuck();
        Quackable mallardDuckThree = countDuckFactory.getMallardDuck();
        Quackable mallardDuckFour = countDuckFactory.getMallardDuck();
        flockOfMallard.add(mallardDuckOne);
        flockOfMallard.add(mallardDuckTwo);
        flockOfMallard.add(mallardDuckThree);
        flockOfMallard.add(mallardDuckFour);

        //将野鸭群添加到鸭子群里
        flockOfDucks.add(flockOfMallard);

        //让观察者观察鸭子群的动作
        DuckObserver duckObserver = new DuckObserver();
        flockOfDucks.registerObserver(duckObserver);

        //=====================================让鸭子开始叫=====================================

        System.out.println("鸭子开始叫！！！");

        System.out.println("=====duck quack=====");
        //让鸭子群开始叫
        simulate(flockOfDucks);

        System.out.println("=====mallard quack=====");
        //野鸭群再叫
        simulate(flockOfMallard);

        //其中混了一个不是鸭子的鹅
        System.out.println("真鸭子叫的次数：" + QuackWithCount.getCount());

    }

    /**
     * 鸭子叫的统一方法
     */
    public void simulate(Quackable quackable) {
        quackable.quack();
    }

}
