package designpattern.other.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 导演类，封装了车模型的获取
 *
 * ArrayList和HashMap如果定义成类的成员变量,
 *      那你在方法中的调用一定要做一个clear的动作,以防止数据混乱
 */
public class Director {

    /**
     * 两个建造器和一个汽车指令列表
     */
    private BMWBuilder bmwBuilder = new BMWBuilder();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private List<String> sequenceList = new ArrayList<>();

    public BenzModel getABenzModel() {
        //每次一定要clear()
        this.sequenceList.clear();
        this.sequenceList.add("start");
        this.sequenceList.add("engine boom");
        this.sequenceList.add("alarm");
        this.sequenceList.add("stop");
        this.benzBuilder.setSequence(this.sequenceList);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BenzModel getBBenzModel() {
        this.sequenceList.clear();
        this.sequenceList.add("start");
        this.sequenceList.add("alarm");
        this.benzBuilder.setSequence(this.sequenceList);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BMWModel getCBMWModel() {
        this.sequenceList.clear();
        this.sequenceList.add("start");
        this.sequenceList.add("engine boom");
        this.sequenceList.add("alarm");
        this.sequenceList.add("stop");
        this.bmwBuilder.setSequence(this.sequenceList);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }

    public BMWModel getDBMWModel() {
        this.sequenceList.clear();
        this.sequenceList.add("start");
        this.sequenceList.add("stop");
        this.bmwBuilder.setSequence(this.sequenceList);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }

}
