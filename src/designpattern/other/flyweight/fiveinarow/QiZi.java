package designpattern.other.flyweight.fiveinarow;

/**
 * 棋子抽象类
 */
public abstract class QiZi {

    public abstract String getColor();

    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色：" + this.getColor() + " 棋子位置：" + coordinate.getX() + "," + coordinate.getY());
    }

}
