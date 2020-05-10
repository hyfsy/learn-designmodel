package designpattern.other.memento.one;

/**
 * 发起人/备忘录/管理者 角色
 */
public class Originator implements Cloneable {

    /**
     * 保存状态
     */
    private Originator originator;

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
    public void saveMemento(){
        this.setOriginator(this.clone());
    }

    /**
     * 还原备份
     */
    public void restoreMemento(){
        if(this.getOriginator()!=null){
            this.setStatus(this.getOriginator().getStatus());
        }
    }

    /**
     * 克隆出一个自己的备份
     */
    @Override
    protected Originator clone() {
        try {
            return (Originator)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
