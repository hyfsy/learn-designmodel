package designpattern.other.memento;

import java.util.Map;

/**
 * 骑士-发起人角色
 */
public class Knight {

    private int blood;
    private int health;
    private int magic;

    /**
     * 初始化骑士
     */
    public Knight(int blood, int health, int magic) {
        this.blood = blood;
        this.health = health;
        this.magic = magic;
    }

    /**
     * 动态获取角色的所有状态
     */
    public IMemento saveStatus() {
        return new Memento(BeanUtil.getProperties(this));
    }

    /**
     * 动态设置角色的所有状态
     */
    public void restoreStatus(IMemento memento) {
        assert memento != null;
        BeanUtil.setProperties(this, ((Memento) memento).getStatusMap());
    }

    /**
     * 黑箱模式-备忘录类
     */
    private class Memento implements IMemento {

        /**
         * 存放对象的所有状态-多保存点
         */
        private Map<String, Object> statusMap;

        private Memento(Map<String, Object> statusMap) {
            this.statusMap = statusMap;
        }

        private Map<String, Object> getStatusMap() {
            return statusMap;
        }

        private void setStatusMap(Map<String, Object> statusMap) {
            this.statusMap = statusMap;
        }
    }

    /**
     * 减少状态
     */
    public void reduceStatus() {
        this.setBlood((int) (this.getBlood() * .8));
        this.setHealth((int) (this.getHealth() * .8));
        this.setMagic((int) (this.getMagic() * .8));
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "blood=" + blood +
                ", health=" + health +
                ", magic=" + magic +
                '}';
    }
}
