package designpattern.other.memento.white;

/**
 * 备忘录对象
 */
public class Memento {

    /**
     * 和要备份的角色相同的属性
     */
    private String status;

    public Memento(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
