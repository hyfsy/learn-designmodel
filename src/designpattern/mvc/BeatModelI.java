package designpattern.mvc;

/**
 * 模型类接口
 */
public interface BeatModelI {

    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();

    /**
     * 让 V、C 注册为观察者的方法
     */
    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    /**
     * BPM改变时才通知
     */
    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}
