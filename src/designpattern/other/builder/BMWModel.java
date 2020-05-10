package designpattern.other.builder;

import java.util.List;

/**
 * 宝马车具体类
 */
public class BMWModel extends CarModel {

    public BMWModel(List<String> sequenceList) {
        super(sequenceList);
    }

    @Override
    protected void start() {
        System.out.println("宝马车启动了");
    }

    @Override
    protected void engineBoom() {
        System.out.println("宝马发动了引擎");
    }

    @Override
    protected void alarm() {
        System.out.println("宝马鸣笛了");
    }

    @Override
    protected void stop() {
        System.out.println("宝马车停下来了");
    }


}
