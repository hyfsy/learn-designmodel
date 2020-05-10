package designpattern.command.concretecommand;

import designpattern.command.Command;
import designpattern.command.executor.GarageDoor;

/**
 * 车库门升起命令
 */
public class GarageDoorUpCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }

}
