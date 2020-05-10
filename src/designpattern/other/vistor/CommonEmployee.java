package designpattern.other.vistor;

/**
 * 普通员工类-元素类
 */
public class CommonEmployee extends Employee {

    private String job;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
