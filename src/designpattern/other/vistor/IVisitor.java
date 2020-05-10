package designpattern.other.vistor;

/**
 * 访问者接口
 */
public interface IVisitor {

    /**
     * 注意此处为具体的被访问者对象
     */
    void visit(CommonEmployee commonEmployee);

    void visit(Manager manager);

}
