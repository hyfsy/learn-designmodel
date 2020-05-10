package designpattern.mvc.heart;

import designpattern.mvc.BPMObserver;
import designpattern.mvc.BeatModelI;
import designpattern.mvc.BeatObserver;

/**
 * 心脏模型适配器
 */
public class HeartModelImplAdapter implements BeatModelI {

    private HeartModelI heartModelI;

    public HeartModelImplAdapter(HeartModelI heartModelI) {
        this.heartModelI = heartModelI;
    }

    @Override
    public int getBPM() {
        return heartModelI.getHeartRate();
    }

    @Override
    public void registerObserver(BeatObserver o) {
        heartModelI.registerObserver(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        heartModelI.removeObserver(o);
    }

    @Override
    public void registerObserver(BPMObserver o) {
        heartModelI.registerObserver(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        heartModelI.removeObserver(o);
    }

    /**
     * 我们不知道这些方法将对心脏做些什么，但是看起来很可怕。所以我们让这些方法“无操作”
     */
    @Override
    public void initialize() {

    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public void setBPM(int bpm) {

    }

}
