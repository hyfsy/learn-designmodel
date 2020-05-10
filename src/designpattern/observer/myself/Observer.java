package designpattern.observer.myself;

/**
 * 观察者接口
 */
public interface Observer {

    /**
     * 通过主题 更新观察者状态
     */
    void update(Subject subject);

}
