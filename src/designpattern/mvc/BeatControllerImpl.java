package designpattern.mvc;

/**
 * 控制器，只关联 M，包含策略模式（视图可以随时更换控制器）
 */
public class BeatControllerImpl implements BeatControllerI {

    private BeatModelI beatModelI;
    //初始化实现类
    private DJView view;

    /**
     * 视图是由控制器生成的
     */
    public BeatControllerImpl(BeatModelI beatModelI) {
        this.beatModelI = beatModelI;
        //初始化视图界面
        view = new DJView(this, beatModelI);
        view.createShows();
        view.createControls();
        view.enableStartMenuItem();
        view.disableStopMenuItem();
        //模型初始化，音频初始化
        beatModelI.initialize();
    }

    @Override
    public void start() {
        beatModelI.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        beatModelI.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    @Override
    public void setBPM(int bpm) {
        beatModelI.setBPM(bpm);
    }

    @Override
    public void increaseBPM() {
        beatModelI.setBPM(beatModelI.getBPM() + 1);
    }

    @Override
    public void decreaseBPM() {
        beatModelI.setBPM(beatModelI.getBPM() - 1);
    }

}
