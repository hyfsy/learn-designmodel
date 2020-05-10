package designpattern.other.memento.black;

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
    public IMemento createMemento(){
        return new Memento(this);
    }

    /**
     * 还原备份
     */
    public void restoreMemento(IMemento memento){
        this.setStatus(((Memento)memento).getStatus());
    }

    /**
     * 黑箱，通过窄接口传输
     */
    private class Memento implements IMemento{
        /**
         * 和要备份的角色相同的属性
         */
        private String status;

        private Memento(Originator originator){
            this.status = originator.getStatus();
        }

        private String getStatus() {
            return status;
        }

        private void setStatus(String status) {
            this.status = status;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
