package designpattern.other.builder;

import java.util.List;

/**
 * 奔驰车具体类
 */
public class BenzModel extends CarModel {

    public BenzModel(List<String> sequenceList) {
        super(sequenceList);
    }

    @Override
    protected void start() {
        System.out.println("奔驰车启动了");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰发动了引擎");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰鸣笛了");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车停下来了");
    }

}
