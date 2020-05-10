package designpattern.iterator;

/**
 * 迭代器接口
 */
public interface MyIterator {

    /**
     * 存在下一个元素
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     */
    Object next();

    /**
     * 删除下一个元素
     */
    void remove();

}
