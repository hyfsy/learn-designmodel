package designpattern.command.executor;

/**
 * 执行者-音响类
 */
public class Stereo {

    public void on(){
        System.out.println("stereo on");
    }

    public void setCD(){
        System.out.println("stereo set CD ...ok");
    }

    /**
     * 设置音量
     */
    public void setVolume(int size){
        System.out.println("stereo set volume " + size);
    }

    public void off(){
        System.out.println("stereo off");
    }

}
