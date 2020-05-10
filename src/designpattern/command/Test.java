package designpattern.command;

import designpattern.command.concretecommand.*;
import designpattern.command.executor.GarageDoor;
import designpattern.command.executor.Light;
import designpattern.command.executor.Stereo;

/**
 * 命令模式
 * 命令模式将"请求"封装成对象,以便使用不同的请求、队列或者日志来参数化其他对象
 * 命令模式也支持可撤销的操作
 */
public class Test {
    public static void main(String[] args) {

        //初始化命令对象
        //电灯实例
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        //车库门实例
        GarageDoor garageDoor = new GarageDoor();
        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);
        //音响实例
        Stereo stereo = new Stereo();
        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);


        //初始化调用者-遥控器对象
        RemoteControl control = new RemoteControl();
        //为遥控器设置命令
        control.setCommand(0, lightOnCommand, lightOffCommand);
        control.setCommand(1, lightOnCommand, lightOffCommand);
        control.setCommand(2, garageDoorUpCommand, garageDoorDownCommand);
        control.setCommand(3, stereoOnCommand, stereoOffCommand);


        //执行对应下标的命令
        control.onButtonWasPushed(3);
        control.offButtonWasPushed(3);
        //输出遥控器的所有信息
        System.out.println(control);
        //撤销按钮
        control.undoButtonWasPushed();
        System.out.println(control);
        //前进一步按钮
        control.forwardButtonWasPushed();
        System.out.println(control);
        control.onButtonWasPushed(1);
        control.offButtonWasPushed(1);
        System.out.println(control);
        //撤销按钮
        control.undoButtonWasPushed();


        //设置宏命令
        Command[] partyOn = {stereoOnCommand, garageDoorUpCommand, lightOnCommand};
        Command[] partyOff = {stereoOffCommand, garageDoorDownCommand, lightOffCommand};
        MacroCommand macroOnCommand = new MacroCommand(partyOn);
        MacroCommand macroOffCommand = new MacroCommand(partyOff);
        control.setCommand(6, macroOnCommand, macroOffCommand);
        System.out.println("------- pushing macro on -------");
        control.onButtonWasPushed(6);
        System.out.println("------- pushing macro off -------");
        control.offButtonWasPushed(6);
        System.out.println(control);

        //测试撤销按钮栈和前进按钮栈
        System.out.println("------- pushing undo on -------");
        control.undoButtonWasPushed();
        control.undoButtonWasPushed();
        control.undoButtonWasPushed();
        control.undoButtonWasPushed();
        System.out.println(control);
        //前进一步按钮
        System.out.println("------- pushing forward on -------");
        control.forwardButtonWasPushed();
        System.out.println(control);
    }
}
