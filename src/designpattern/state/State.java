package designpattern.state;

import java.io.Serializable;

/**
 * 状态接口，每个方法代表当前状态的行为(扩展了远程代理必须的接口)
 */
public interface State extends Serializable {

    /**
     * 放入0.25美元
     */
    void insertQuarter();

    /**
     * 弹出硬币
     */
    void ejectQuarter();

    /**
     * 旋转转轴
     */
    void turnCrank();

    /**
     * 分配糖果
     */
    void dispense();
}
