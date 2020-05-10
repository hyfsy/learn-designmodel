package designpattern.other.builder;

import java.util.List;

/**
 * 宝马车生产类
 */
public class BMWBuilder extends CarBuilder {

    @Override
    protected void setSequence(List<String> sequenceList) {
        this.setCarModel(new BMWModel(sequenceList));
    }

}
