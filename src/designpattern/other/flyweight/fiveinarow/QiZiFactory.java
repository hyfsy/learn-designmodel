package designpattern.other.flyweight.fiveinarow;

import java.util.Hashtable;

/**
 * 棋子工厂，初始化时自动创建两种棋子
 */
public class QiZiFactory {

    private static QiZiFactory factory = new QiZiFactory();
    private static Hashtable<String, QiZi> qiZiTable;
    private QiZi white, black;

    /**
     * 单例保证只初始化一次
     */
    private QiZiFactory() {
        qiZiTable = new Hashtable<>();
        white = new WhiteQiZi();
        black = new BlackQiZi();
        qiZiTable.put("white", white);
        qiZiTable.put("black", black);
    }

    public static QiZiFactory getFactory() {
        return factory;
    }

    /**
     * 通过对应颜色获取享元棋子
     */
    public static QiZi getIgoChessman(String color) {
        return qiZiTable.get(color);
    }

}
