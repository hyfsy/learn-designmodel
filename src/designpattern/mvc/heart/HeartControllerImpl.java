package designpattern.mvc.heart;

import designpattern.mvc.BeatControllerI;
import designpattern.mvc.DJView;

/**
 * 心脏模型的控制器
 */
public class HeartControllerImpl implements BeatControllerI {

    private HeartModelI heartModelI;
    private DJView djView;

    public HeartControllerImpl(HeartModelI heartModelI) {
        this.heartModelI = heartModelI;
        djView = new DJView(this, new HeartModelImplAdapter(heartModelI));
        djView.createShows();
        djView.createControls();
        djView.enableStartMenuItem();
        djView.disableStopMenuItem();
    }

    /**
     * 不做任何操作
     */
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void setBPM(int bpm) {

    }

    @Override
    public void increaseBPM() {

    }

    @Override
    public void decreaseBPM() {

    }
}
