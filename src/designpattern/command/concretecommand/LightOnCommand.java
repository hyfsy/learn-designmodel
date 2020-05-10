package designpattern.command.concretecommand;

import designpattern.command.Command;
import designpattern.command.executor.Light;

/**
 * 电灯开启命令
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        light.on();
    }

    /**
     * 撤销命令
     */
    @Override
    public void undo() {
        light.off();
    }
}
