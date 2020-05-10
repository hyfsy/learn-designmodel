package designpattern.command.concretecommand;

import designpattern.command.Command;
import designpattern.command.executor.GarageDoor;

/**
 * 车库门下降命令
 */
public class GarageDoorDownCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}
