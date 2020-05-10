package designpattern.other.builder;

import java.util.List;

/**
 * 奔驰车生成类
 */
public class BenzBuilder extends CarBuilder {

    @Override
    protected void setSequence(List<String> sequenceList) {
        this.setCarModel(new BenzModel(sequenceList));
    }

}
