package designpattern.iterator;

import java.util.Arrays;

public class ConcreteArray implements Standard {

    private String[] strArray;

    /**
     * 初始化对象数组
     */
    public ConcreteArray(String[] strArray) {
        this.strArray = strArray;
    }

    /**
     * 获取具体数组迭代器
     */
    @Override
    public MyIterator getIterator() {
        return new ArrayIterator(strArray);
    }

    //测试查看用方法
    void printArray(){
        System.out.println(Arrays.toString(strArray));
    }

}
