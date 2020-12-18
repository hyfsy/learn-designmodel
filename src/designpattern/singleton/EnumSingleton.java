package designpattern.singleton;

/**
 * 枚举单例
 * <p>
 * 调用：EnumSingleton.getInstance();
 */
public class EnumSingleton {

    private EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private EnumSingleton instance;

        // 构造函数只会被装载一次
        Singleton() {
            instance = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return instance;
        }
    }
}
