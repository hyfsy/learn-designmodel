package designpattern.mvc.heart;

import designpattern.mvc.BPMObserver;
import designpattern.mvc.BeatObserver;

/**
 * 心脏模型接口
 */
public interface HeartModelI {

    int getHeartRate();

    void registerObserver(BPMObserver o);

    void registerObserver(BeatObserver o);

    void removeObserver(BPMObserver o);

    void removeObserver(BeatObserver o);

    void notifyBPMObserver();

    void notifyBeatObserver();

}
