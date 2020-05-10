package designpattern.facade;

import designpattern.facade.executor.DvdPlayer;
import designpattern.facade.executor.PopcornPopper;
import designpattern.facade.executor.Projector;
import designpattern.facade.executor.Screen;

/**
 * 外观模式
 * 外观模式提供了一个统一的接口,用来访问子系统中的一群接口。外观定义了一个高层接口,让子系统更容易使用
 *
 * 与适配器模式的区别：
 *      外观和适配器可以包装许多类,但是外观的意图是简化接口,而适配器的意图是将接口转换成不同接口
 */
public class Test {
    public static void main(String[] args) {
        PopcornPopper popcornPopper = new PopcornPopper();
        Screen screen = new Screen();
        Projector projector = new Projector();
        DvdPlayer dvdPlayer = new DvdPlayer();
        //正确的做法是用接口初始化
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(popcornPopper, screen, projector, dvdPlayer);
        homeTheaterFacade.watchMovie();
        System.out.println("========================");
        homeTheaterFacade.endMovie();
    }
}
