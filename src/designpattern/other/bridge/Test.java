package designpattern.other.bridge;

/**
 * 桥接模式
 *
 * 将抽象和实现解耦,使得两者可以独立地变化
 *
 * 优点：
 *      1. 分离抽象接口及其实现部分。所谓抽象和实现沿着各自维度的变化，
 *              也就是说抽象和实现不再在同一个继承层次结构中，而是“子类化”它们，
 *              使它们各自都具有自己的子类，以便任何组合子类，从而获得多维度组合对象
 *   2. 桥接模式提高了系统的可扩展性，在两个变化维度中任意扩展一个维度，
 *              都不需要修改原有系统，符合“开闭原则”
 *
 */
public class Test {
    public static void main(String[] args) {
        IColor redColor = new RedColor();
        IColor whiteColor = new WhiteColor();

        Shape square = new SquareShape();
        Shape circle = new CircleShape();

        square.setColor(redColor);
        square.draw();
        square.setColor(whiteColor);
        square.draw();
    }
}
