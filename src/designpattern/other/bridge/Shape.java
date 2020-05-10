package designpattern.other.bridge;

/**
 * 桥接抽象类（IColor搭了一个桥，接到此抽象类）
 *
 * 抽象类中的所有的方法/属性都是以实现（implements）方式实现的
 * 具体子类是以抽象方式实现的
 */
public abstract class Shape {
    protected IColor color;

    public void setColor(IColor color) {
        this.color = color;
    }

    public abstract void draw();

}
