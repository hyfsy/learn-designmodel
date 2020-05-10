package designpattern.singleton;

/**
 * 静态内部类单例
 *
 * 内部饿汉，外部懒汉，神乎其技
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton(){}

    private static class SingletonHolder{
        private static final StaticInnerSingleton singleton = new StaticInnerSingleton();
    }

    public static final StaticInnerSingleton getSingleton(){
        //调用时才装载内部类
        return SingletonHolder.singleton;
    }


}
