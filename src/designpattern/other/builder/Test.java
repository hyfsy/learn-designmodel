package designpattern.other.builder;

/**
 * 建造者模式
 *
 * 将一个复杂对象的构建与它的表示分离,使得同样的构建过程可以创建不同的表示
 *
 *       汽车模型使用了模板方法模式
 *
 * 1、使用建造者模式可以使客户端不必知道产品内部组成的细节
 * 2、建造者独立，易于扩展
 * 3、由于具体的建造者是独立的,因此可以对建造过程逐步细化,而不对其他的模块产生任何影响
 */
public class Test {
    public static void main(String[] args) {

        //创建一个导演类，专门生成汽车
        Director director = new Director();

        //获取车辆
        BenzModel aBenzModel = director.getABenzModel();
        BenzModel bBenzModel = director.getBBenzModel();
        BMWModel cBmwModel = director.getCBMWModel();
        BMWModel dBmwModel = director.getDBMWModel();

        //汽车开始跑，执行对应的动作
        aBenzModel.run();
        System.out.println("====================");
        bBenzModel.run();
        System.out.println("====================");
        cBmwModel.run();
        System.out.println("====================");
        dBmwModel.run();
    }
}
