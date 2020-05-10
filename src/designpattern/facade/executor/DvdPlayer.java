package designpattern.facade.executor;

/**
 * DVD播放器
 */
public class DvdPlayer {

    public void on(){
        System.out.println("DVD on");
    }

    public void play(String movieName){
        System.out.println("DVD play "+ movieName +" now");
    }

    public void off(){
        System.out.println("DVD off");
    }

}
