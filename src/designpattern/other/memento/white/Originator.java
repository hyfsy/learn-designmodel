package designpattern.other.memento.white;

/**
 * 发起人角色
 */
public class Originator {

    /**
     * 状态值
     */
    private String status;

    public Originator(String status){
        this.setStatus(status);
    }

    /**
     * 创建备份
     */
    public Memento createMemento(){
        return new Memento(this.getStatus());
    }

    /**
     * 还原备份
     */
    public void restoreMemento(Memento memento){
        this.setStatus(memento.getStatus());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
