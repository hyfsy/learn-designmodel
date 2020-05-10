package designpattern.command.concretecommand;

import designpattern.command.Command;
import designpattern.command.executor.Stereo;

/**
 * 音响关闭命令
 */
public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo){
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    /**
     * 设置多个要执行的命令
     */
    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
