package designpattern.iterator.combination;

import java.util.Iterator;
import java.util.Stack;

/**
 * 组合迭代器
 * <p>
 * 外部迭代器，可以自己控制遍历,更加灵活
 */
public class CompositeIterator implements Iterator {

    /**
     * 组合迭代器栈
     * 使用堆栈维护我们的位置
     */
    private Stack<Iterator> stack = new Stack<>();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {

        //检查堆栈是否被清空
        if (stack.empty()) {
            return false;
        } else {
            //判断当前迭代器中是否还有元素
            Iterator iterator = stack.peek();
            if (iterator.hasNext()) {
                return true;
            } else {
                //弹出当前迭代器
                stack.pop();
                //递归判断下一个迭代器
                return hasNext();
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Iterator iterator = stack.peek();
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            if (menuComponent instanceof Menu) {
                //获取当前对象的迭代器放入栈中
                stack.push(menuComponent.getIterator());
            }
            return menuComponent;
        } else {
            return null;
        }
    }

    /**
     * 此处不支持删除操作
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException("don't support remove operation");
    }

}
