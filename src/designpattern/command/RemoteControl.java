package designpattern.command;

import java.util.Stack;

/**
 * 调用者-遥控器类
 */
public class RemoteControl {

    /**
     * 默认 七组 命令
     */
    private static final int COMMAND_COUNT = 7;

    /**
     * 启动命令
     */
    private Command[] onCommand;

    /**
     * 关闭命令
     */
    private Command[] offCommand;

    /**
     * 撤销命令栈
     */
    private Stack<Command> undoCommand;

    /**
     * 前进命令栈
     */
    private Stack<Command> forwardCommand;

    /**
     * 初始化所有命令对象及数组
     */
    public RemoteControl() {
        onCommand = new Command[COMMAND_COUNT];
        offCommand = new Command[COMMAND_COUNT];
        Command noCommand = new NoCommand();
        //循环添加空对象
        for (int i = 0; i < COMMAND_COUNT; i++) {
            onCommand[i] = noCommand;
            offCommand[i] = noCommand;
        }
        //初始化栈
        undoCommand = new Stack<>();
        forwardCommand = new Stack<>();
    }

    /**
     * 根据下标设置对应命令
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    /**
     * 开启按钮-根据数组下标启动对应命令
     */
    public void onButtonWasPushed(int slot) {
        onCommand[slot].execute();
        //将该命令放入撤销命令
        undoCommand.push(onCommand[slot]);
        //清空前进命令栈
        forwardCommand.clear();
    }

    /**
     * 关闭按钮-根据下标执行对应命令
     */
    public void offButtonWasPushed(int slot) {
        offCommand[slot].execute();
        //将该命令放入撤销命令
        undoCommand.push(offCommand[slot]);
        forwardCommand.clear();
    }

    /**
     * 撤销按钮-执行前一个命令的undo方法
     */
    public void undoButtonWasPushed() {
        //判断栈不为空才执行操作
        if (!undoCommand.isEmpty()) {
            //弹栈
            Command undo = undoCommand.pop();
            //获取命令执行撤销方法
            undo.undo();
            //压栈
            forwardCommand.push(undo);
        }
    }

    /**
     * 前进一步按钮，执行撤销前的操作
     */
    public void forwardButtonWasPushed() {
        if (!forwardCommand.empty()) {
            Command forward = forwardCommand.pop();
            forward.execute();
            undoCommand.push(forward);
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------- Remote Control -------\n");
        //输出装载的命令
        for (int i = 0; i < COMMAND_COUNT; i++) {
            stringBuffer.append("[slot " + i + "] " + onCommand[i].getClass().getSimpleName()
                    + "     " + offCommand[i].getClass().getSimpleName() + "\n");
        }
        //输出所有撤销命令
        for (Command command : undoCommand) {
            stringBuffer.append("[undo] " + command.getClass().getSimpleName() + "\n");
        }
        //输出所有前进命令
        for (Command command : forwardCommand) {
            stringBuffer.append("[forward] " + command.getClass().getSimpleName() + "\n");
        }

        return stringBuffer.toString();
    }
}
