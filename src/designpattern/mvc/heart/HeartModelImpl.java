package designpattern.mvc.heart;

import designpattern.mvc.BPMObserver;
import designpattern.mvc.BeatObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 具体心脏动作实现，自启动线程
 */
public class HeartModelImpl implements HeartModelI, Runnable {

    private List<BPMObserver> bpmObservers = new ArrayList<>();
    private List<BeatObserver> beatObservers = new ArrayList<>();
    private int time = 1000;
    private int bpm = 90;
    private Random random = new Random(System.currentTimeMillis());
    private Thread thread;

    public HeartModelImpl() {
        thread = new Thread(this);
        thread.start();
    }

    /**
     * 模拟心脏跳动
     */
    @Override
    public void run() {
        int lastRate = -1;
        for (; ; ) {
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0) {
                change = 0 - change;
            }
            int rate = 60000 / (time - change);
            if (rate < 120 && rate > 50) {
                time += change;
                notifyBeatObserver();
                if (lastRate != rate) {
                    lastRate = rate;
                    notifyBPMObserver();
                }
            }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取心脏跳动频率
     */
    @Override
    public int getHeartRate() {
        return 60000 / time;
    }

    /**
     * 观察者事件
     */
    @Override
    public void registerObserver(BPMObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(BPMObserver o) {
        int index = bpmObservers.indexOf(o);
        if (index >= 0) {
            bpmObservers.remove(index);
        }
    }

    @Override
    public void removeObserver(BeatObserver o) {
        int index = beatObservers.indexOf(o);
        if (index >= 0) {
            beatObservers.remove(index);
        }
    }

    @Override
    public void notifyBPMObserver() {
        for (BPMObserver observer : bpmObservers) {
            observer.updateBPM();
        }
    }

    @Override
    public void notifyBeatObserver() {
        for (BeatObserver observer : beatObservers) {
            observer.updateBeat();
        }
    }

}
