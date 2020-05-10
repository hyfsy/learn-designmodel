package designpattern.mvc;

/**
 * 复合模式：MVC
 * <p>
 * 视图（View）用了组合模式
 * 控制器（Controller）用了策略模式
 * 模型（Model）用了观察者模式
 */
public class Test {
    public static void main(String[] args) {
        //创建模型
        BeatModelI beatModelI = new BeatModelImpl();

        //通过控制器创建视图
        new BeatControllerImpl(beatModelI);

//        HeartModelI heartModelI = new HeartModelImpl();
//        new HeartControllerImpl(heartModelI);
    }
}
