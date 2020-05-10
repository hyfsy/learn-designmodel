package designpattern.other.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * 享元模式：
 * 使用共享对象可有效地支持大量的细粒度的对象
 * <p>
 * 优点：
 * 可以极大减少内存中对象的数量，使得相同或相似对象在内存中只保存一份
 * 享元模式的外部状态相对独立，而且不会影响其内部状态，从而使得享元对象可以在不同的环境中被共享
 * 缺点：
 * 使得系统变得复杂，需要分离出内部状态和外部状态
 * 享元模式需要将享元对象的部分状态外部化，而读取外部状态将使得运行时间变长
 * <p>
 * 单纯享元模式
 * 所有的具体享元类都是可以共享的，不存在非共享具体享元类
 * 复合享元模式
 * 将一些单纯享元对象使用组合模式加以组合，还可以形成复合享元对象
 * 对象本身不能共享，但是它们可以分解成单纯享元对象，而后者则可以共享
 * 如果希望为多个内部状态不同的享元对象设置相同的外部状态，可以考虑使用复合享元模式
 */
public class Test {
    public static void main(String[] args) {
        //多个内部状态不同
        List<String> stateList = new ArrayList<>();
        stateList.add("A");
        stateList.add("B");
        stateList.add("C");
        stateList.add("A");

        FlyweightFactory factory = new FlyweightFactory();
        Flyweight compositeFlyweight1 = factory.createFlyweight(stateList);
        Flyweight compositeFlyweight2 = factory.createFlyweight(stateList);

        //相同的外部状态
        compositeFlyweight1.operation("外部状态");
        compositeFlyweight2.operation("外部状态");

        System.out.println("=======================================");

        System.out.println(compositeFlyweight1);
        System.out.println(compositeFlyweight2);

    }
}
