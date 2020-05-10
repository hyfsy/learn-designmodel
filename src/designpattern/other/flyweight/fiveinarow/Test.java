package designpattern.other.flyweight.fiveinarow;

/**
 * 五子棋
 */
public class Test {
    public static void main(String[] args) {
        QiZiFactory factory = QiZiFactory.getFactory();
        QiZi white1, white2, black1, black2;
        white1 = QiZiFactory.getIgoChessman("white");
        white2 = QiZiFactory.getIgoChessman("white");
        System.out.println("两颗白子是否相同：" + (white1 == white2));
        black1 = QiZiFactory.getIgoChessman("black");
        black2 = QiZiFactory.getIgoChessman("black");
        System.out.println("两颗黑子是否相同：" + (black1 == black2));

        white1.display(new Coordinate(1, 2));
        white2.display(new Coordinate(3, 4));
        black1.display(new Coordinate(5, 6));
        black2.display(new Coordinate(7, 8));

    }
}
