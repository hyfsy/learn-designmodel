package designpattern.other.chainofresponsibility;

/**
 * 父亲的责任
 */
public class FatherResponsibility extends ResponsibilityI {

    /**
     * 初始化该处理器的责任等级
     */
    public FatherResponsibility(int responsibilityLevel) {
        super(responsibilityLevel);
    }

    /**
     * 处理信息
     */
    @Override
    protected void response() {
        System.out.println("父亲批准了！");
    }

}
