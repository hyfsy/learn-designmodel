package designpattern.facade;

import designpattern.facade.executor.DvdPlayer;
import designpattern.facade.executor.PopcornPopper;
import designpattern.facade.executor.Projector;
import designpattern.facade.executor.Screen;

/**
 * 家庭影院外观
 */
public class HomeTheaterFacade {

    /**
     * 爆米花机
     */
    private PopcornPopper popcornPopper;

    /**
     * 投影仪
     */
    private Projector projector;

    /**
     * 屏幕
     */
    private Screen screen;

    /**
     * DVD播放器
     */
    private DvdPlayer dvdPlayer;

    /**
     * 初始化所有关联对象
     * 正确的做法是用接口初始化
     */
    public HomeTheaterFacade(PopcornPopper popcornPopper, Screen screen, Projector projector, DvdPlayer dvdPlayer) {
        this.popcornPopper = popcornPopper;
        this.projector = projector;
        this.screen = screen;
        this.dvdPlayer = dvdPlayer;
    }

    public void watchMovie() {
        //开启爆米花
        popcornPopper.on();
        popcornPopper.pop();
        //放下屏幕
        screen.down();
        //打开投影仪
        projector.on();
        //播放电影
        dvdPlayer.on();
        dvdPlayer.play("three pig");
    }

    public void endMovie() {
        //关闭爆米花机
        popcornPopper.off();
        //屏幕上升
        screen.up();
        //关闭投影仪
        projector.off();
        //关闭 DVD
        dvdPlayer.off();
    }

}
