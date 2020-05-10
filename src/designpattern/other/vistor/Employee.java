package designpattern.other.vistor;

/**
 * 员工抽象类
 */
public abstract class Employee {

    private String name;
    private int salary;

    public abstract void accept(IVisitor visitor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
