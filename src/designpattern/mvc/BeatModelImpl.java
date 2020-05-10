package designpattern.mvc;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Model层，创建音频的模型，包含观察者模式（更新后通知 V、C）
 */
public class BeatModelImpl implements BeatModelI, MetaEventListener {

    /**
     * 定序器知道如何产生真实的节拍
     */
    private Sequencer sequencer;
    private List<BeatObserver> beatList = new ArrayList<>();
    private List<BPMObserver> bpmList = new ArrayList<>();

    /**
     * 其他的实例变量
     */
    private Sequence sequence;
    private Track track;

    /**
     * 默认频率值
     */
    private int bpm = 90;

    @Override
    public void initialize() {
        //设置定序器和节拍音轨
        setUpMidi();
        buildTrackAndStart();
    }

    @Override
    public void on() {
        sequencer.start();
        setBPM(90);
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    /**
     * 新的节拍开始时被调用
     */
    public void beatEvent() {
        notifyBeatObservers();
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatList.add(o);
    }

    @Override
    public void registerObserver(BPMObserver o) {
        bpmList.add(o);
    }

    public void notifyBPMObservers() {
        for (BPMObserver bpmObserver : bpmList) {
            bpmObserver.updateBPM();
        }
    }

    public void notifyBeatObservers() {
        for (BeatObserver beatObserver : beatList) {
            beatObserver.updateBeat();
        }
    }

    @Override
    public void removeObserver(BeatObserver o) {
        int index = beatList.indexOf(o);
        if (index >= 0) {
            beatList.remove(index);
        }
    }

    @Override
    public void removeObserver(BPMObserver o) {
        int index = bpmList.indexOf(o);
        if (index >= 0) {
            bpmList.remove(index);
        }
    }

    @Override
    public void meta(MetaMessage meta) {
        if (meta.getType() == 47) {
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    /**
     * emmmm
     */
    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);

            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * emmmm
     */
    public void buildTrackAndStart() {
        int[] tracks = {35, 0, 46, 0};
        sequence.deleteTrack(null);
        track = sequence.createTrack();
        makeTracks(tracks);
        track.add(makeEvent(129, 9, 1, 0, 4));
        try {
            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * emmmm
     */
    public void makeTracks(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    /**
     * emmmm
     */
    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent midiEvent = null;
        ShortMessage shortMessage = new ShortMessage();
        try {
            shortMessage.setMessage(comd, chan, one, two);
            midiEvent = new MidiEvent(shortMessage, tick);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return midiEvent;
    }

}
