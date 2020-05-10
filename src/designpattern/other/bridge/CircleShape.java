package designpattern.other.bridge;

/**
 * 圆形实现类
 */
public class CircleShape extends Shape {

    @Override
    public void draw() {
        super.color.getColor();
        System.out.println("圆形");
    }

}
