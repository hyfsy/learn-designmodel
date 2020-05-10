package designpattern.mvc;

/**
 * 控制器接口
 */
public interface BeatControllerI {

    void start();

    void stop();

    void setBPM(int bpm);

    void increaseBPM();

    void decreaseBPM();

}
