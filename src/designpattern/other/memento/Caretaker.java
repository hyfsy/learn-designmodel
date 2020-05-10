package designpattern.other.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * 备忘录管理者
 */
public class Caretaker {

    /**
     * 多存档点
     *
     * 注意内存溢出问题,该备份一旦产生就装入内存,没有任何销毁的意向,这是非常危险的。
     * 在系统设计时,要严格限定备忘录的创建,建议增加Map的上限,否则系统很容易产生内存溢出情况。
     */
    private Map<String, IMemento> iMementoMap = new HashMap<>();

    /**
     * 保存状态
     */
    public void saveMemento(String index, IMemento memento) {
        this.getMementoMap().put(index, memento);
    }

    /**
     * 还原状态
     */
    public IMemento restoreMemento(String index) {
        return this.getMementoMap().get(index);
    }

    public Map<String, IMemento> getMementoMap() {
        return iMementoMap;
    }

    public void setMementoMap(Map<String, IMemento> iMementoMap) {
        this.iMementoMap = iMementoMap;
    }

}
