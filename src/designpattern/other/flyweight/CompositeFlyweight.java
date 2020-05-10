package designpattern.other.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 复合享元角色类
 */
public class CompositeFlyweight implements Flyweight {

    /**
     * 享元对象集合
     */
    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    /**
     * 集合增加方法
     */
    public void add(String key, Flyweight flyweight) {
        flyweightMap.put(key, flyweight);
    }

    @Override
    public void operation(String state) {
        Flyweight flyweight = null;
        for (Map.Entry<String, Flyweight> entry : flyweightMap.entrySet()) {
            flyweight = flyweightMap.get(entry.getKey());
            //为享元对象集合设置相同的外部状态
            flyweight.operation(state);
        }
    }

    @Override
    public String toString() {
        return "CompositeFlyweight{" +
                "flyweightMap=" + flyweightMap +
                '}';
    }
}
