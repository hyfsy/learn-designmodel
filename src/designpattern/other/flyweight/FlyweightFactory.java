package designpattern.other.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 享元工厂类
 */
public class FlyweightFactory {

    /**
     * 享元缓存池
     */
    private Map<String, Flyweight> flyweightMap = new HashMap<>();

    /**
     * 创建复合享元对象
     *
     * @param stateList 多个内部状态的集合
     * @return 复合享元对象
     */
    public Flyweight createFlyweight(List<String> stateList) {
        //先创建一个空对象
        CompositeFlyweight compositeFlyweight = new CompositeFlyweight();
        for (String state : stateList) {
            //两种行为，添加到工厂集合中以及自己的集合中，保证不会创建第二个
            compositeFlyweight.add(state, createFlyweight(state));
        }
        return compositeFlyweight;
    }

    /**
     * 创建享元对象
     *
     * @param state 外部状态
     * @return 单个享元对象
     */
    public Flyweight createFlyweight(String state) {
        Flyweight flyweight = flyweightMap.get(state);
        //缓存池内不存在就单独创建一个对象并添加到缓存池内
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(state);
            flyweightMap.put(state, flyweight);
        }
        return flyweight;
    }

    public Map<String, Flyweight> getFlyweightMap() {
        return flyweightMap;
    }

    public void setFlyweightMap(Map<String, Flyweight> flyweightMap) {
        this.flyweightMap = flyweightMap;
    }
}
