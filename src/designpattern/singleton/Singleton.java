package designpattern.singleton;

/**
 * 单例模式
 *
 * 私有构造、线程安全
 *
 * jdk 1.2 gc有bug，如果一个单件只有本单件类引用它本身,那么该单件就会被当做垃圾清除
 */
public class Singleton {

    // 1.5后才有用
    // volatile关键字的一个作用是禁止指令重排，对它的写操作就会有一个内存屏障
    // 这样，在它的赋值完成之前，就不会调用读操作
    private volatile static Singleton uniqueInstance = null;

    private Singleton() {
    }

    /**
     * 双重检查锁实现
     */
    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
