package designpattern.other.vistor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构类
 */
public class ObjectStructure {

    /**
     * 结构对象
     */
    private List<Employee> employeeList = new ArrayList<>();

    /**
     * 初始化两个员工
     */
    public ObjectStructure(){
        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.setName("张三");
        commonEmployee.setSalary(1024);
        commonEmployee.setJob("编写Java程序,绝对的蓝领、苦工加搬运工");
        employeeList.add(commonEmployee);

        Manager manager = new Manager();
        manager.setName("李四");
        manager.setSalary(10086);
        manager.setPerformance("基本上是负值，但是我会拍马屁啊");
        employeeList.add(manager);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}
