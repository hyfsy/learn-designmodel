package designpattern.other.builder;

import java.util.List;

/**
 * 建造汽车的抽象父类
 */
public abstract class CarBuilder {

    private CarModel carModel;

    /**
     * 设置汽车的制造顺序
     */
    protected abstract void setSequence(List<String> sequenceList);

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }
}
