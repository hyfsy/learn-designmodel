package designpattern.other.bridge;

/**
 * 具体颜色
 */
public class WhiteColor implements IColor {

    @Override
    public void getColor() {
        System.out.print("白色的");
    }

}
