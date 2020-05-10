package designpattern.iterator;

import java.util.Iterator;

/**
 * 迭代器模式
 * 迭代器模式提供一种方法顺序访问一个聚合对象中的各个元素,而又不暴露其内部的表示
 */
public class Test {
    public static void main(String[] args) {
        //具体查看此接口
        Iterator iterator;

        String[] strArray = new String[]{"1", "2", "3", "4", "5"};

        //初始化数组对象
        ConcreteArray concreteArray = new ConcreteArray(strArray);

        //获取迭代器
        MyIterator arrayIterator = concreteArray.getIterator();

        arrayIterator.next();
        arrayIterator.next();
        //删除第三个元素
        arrayIterator.remove();

        //打印数组
        concreteArray.printArray();

        //用迭代器继续遍历数组
        while(arrayIterator.hasNext()){
            System.out.println(arrayIterator.next());
        }


    }
}
