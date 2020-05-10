package designpattern.command.concretecommand;

import designpattern.command.Command;
import designpattern.command.executor.Stereo;

/**
 * 音响开启命令
 */
public class StereoOnCommand implements Command {

    private Stereo stereo;

    public StereoOnCommand(Stereo stereo){
        this.stereo = stereo;
    }

    /**
     * 设置多个要执行的命令
     */
    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }

}
