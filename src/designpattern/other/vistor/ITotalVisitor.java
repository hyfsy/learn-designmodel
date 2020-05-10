package designpattern.other.vistor;

/**
 * 计算员工工资总和的访问者接口
 */
public interface ITotalVisitor extends IVisitor {

    void countTotalSalary();

}
