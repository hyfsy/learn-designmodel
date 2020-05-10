package designpattern.other.bridge;

/**
 * 具体颜色
 */
public class RedColor implements IColor {

    @Override
    public void getColor() {
        System.out.print("红色的");
    }

}
