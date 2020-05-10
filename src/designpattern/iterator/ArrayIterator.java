package designpattern.iterator;

/**
 * 具体 数组迭代器
 */
public class ArrayIterator implements MyIterator {

    private Object[] array;

    private int index = 0;

    /**
     * 迭代器初始化数组
     */
    public ArrayIterator(Object[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        //数组还需要判断是否为null
        return index < array.length && array[index] != null;
    }

    @Override
    public Object next() {
        //偏移指针
        index++;
        //获取指针偏移前的值
        return array[index - 1];
    }

    /**
     * 数组删除操作
     */
    @Override
    public void remove() {
        //将删除值 后的所有元素 向前移动
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        //最后一个值赋 null
        array[array.length - 1] = null;
    }

}
