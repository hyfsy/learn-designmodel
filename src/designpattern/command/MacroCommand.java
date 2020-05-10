package designpattern.command;

/**
 * 宏命令
 */
public class MacroCommand implements Command {

    /**
     * 命令数组
     */
    private Command[] commands;

    /**
     * 直接初始化命令数组
     */
    public MacroCommand(Command[] commands){
        this.commands = commands;
    }

    /**
     * 一次性执行宏
     */
    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    /**
     * 撤销宏
     */
    @Override
    public void undo() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].undo();
        }
    }
}
