package designpattern.other.vistor;

/**
 * 展示员工信息的具体访问者
 */
public class ShowVisitor implements IShowVisitor {

    private String info = "";

    @Override
    public void report() {
        System.out.println(this.info);
    }

    @Override
    public void visit(CommonEmployee commonEmployee) {
        this.info += this.getBaseInfo(commonEmployee);
        this.info += "工作：" + commonEmployee.getJob() + "\t\n";
    }

    @Override
    public void visit(Manager manager) {
        this.info += this.getBaseInfo(manager);
        this.info += "业绩：" + manager.getPerformance() + "\t\n";
    }

    /**
     * 获取员工的基本信息
     */
    private String getBaseInfo(Employee employee) {
        String info = "姓名：" + employee.getName() + "\t";
        info += "薪水：" + employee.getSalary() + "\t";
        return info;
    }

}
