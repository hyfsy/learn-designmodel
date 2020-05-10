package designpattern.other.bridge;

/**
 * 正方形实现类
 */
public class SquareShape extends Shape {

    @Override
    public void draw() {
        super.color.getColor();
        System.out.println("正方形");
    }

}
