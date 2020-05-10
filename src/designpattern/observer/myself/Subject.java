package designpattern.observer.myself;

/**
 * 主题接口
 */
public interface Subject {
    /**
     * 增加观察者
     */
    void addSubject(Observer o);

    /**
     * 删除观察者
     */
    void removeSubject(Observer o);

    /**
     * 通知观察者
     */
    void performSubject();
}
