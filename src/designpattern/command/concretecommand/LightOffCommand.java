package designpattern.command.concretecommand;

import designpattern.command.Command;
import designpattern.command.executor.Light;

/**
 * 电灯关闭命令
 */
public class LightOffCommand implements Command {

    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        light.off();
    }

    /**
     * 撤销命令
     */
    @Override
    public void undo() {
        light.on();
    }
}
