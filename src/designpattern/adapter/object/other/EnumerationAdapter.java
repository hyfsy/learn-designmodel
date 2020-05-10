package designpattern.adapter.object.other;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 枚举适配器，用来适配list迭代器
 */
public class EnumerationAdapter implements Enumeration {

    private Iterator iterator;

    public EnumerationAdapter(Iterator iterator){
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
