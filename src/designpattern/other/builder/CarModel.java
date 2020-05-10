package designpattern.other.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 原始汽车模型（模板方法）
 */
public abstract class CarModel {

    private List<String> sequenceList;

    public CarModel(List<String> sequenceList) {
        this.sequenceList = new ArrayList<>(sequenceList);
    }

    public List<String> getSequenceList() {
        return sequenceList;
    }

    public void setSequenceList(List<String> sequenceList) {
        this.sequenceList = sequenceList;
    }

    protected abstract void start();

    protected abstract void engineBoom();

    protected abstract void alarm();

    protected abstract void stop();

    public final void run() {
        for (String order : sequenceList) {

            order = order.toLowerCase().replace(" ", "");
            switch (order) {
                case "start":
                    this.start();
                    break;
                case "engineboom":
                    this.engineBoom();
                    break;
                case "alarm":
                    this.alarm();
                    break;
                case "stop":
                    this.stop();
                    break;
                default:
                    break;
            }
        }
    }

}
