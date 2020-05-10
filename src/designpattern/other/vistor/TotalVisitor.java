package designpattern.other.vistor;

/**
 * 获取工资总和的具体访问者
 */
public class TotalVisitor implements ITotalVisitor {

    /**
     * 员工的工资比例系数
     */
    private static final int MANAGER_COEFFICIENT = 5;
    private static final int COMMON_EMPLOYEE_COEFFICIENT = 2;

    /**
     * 对应阶级的员工的工资
     */
    private int commonTotalSalary = 0;
    private int managerTotalSalary = 0;

    /**
     * 输出工资总额
     */
    @Override
    public void countTotalSalary() {
        System.out.println("本公司的月总额：" + (this.commonTotalSalary + this.managerTotalSalary));
    }

    /**
     * 两个方法计算工资总额
     */
    @Override
    public void visit(CommonEmployee commonEmployee) {
        this.commonTotalSalary = this.commonTotalSalary + commonEmployee.getSalary() * COMMON_EMPLOYEE_COEFFICIENT;
    }

    @Override
    public void visit(Manager manager) {
        this.managerTotalSalary = this.managerTotalSalary + manager.getSalary() * MANAGER_COEFFICIENT;
    }

}
