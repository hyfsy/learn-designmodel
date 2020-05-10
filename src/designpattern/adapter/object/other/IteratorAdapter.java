package designpattern.adapter.object.other;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 迭代器适配器，用来适配枚举
 */
public class IteratorAdapter implements Iterator {

    private Enumeration enumeration;

    public IteratorAdapter(Enumeration enumeration){
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        //枚举无法实现删除方法，所以只能抛异常（Iterator默认会抛此异常）
        throw new UnsupportedOperationException();
    }
}
