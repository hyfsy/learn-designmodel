package designpattern.other.chainofresponsibility;

/**
 * 丈夫的责任
 */
public class HusbandResponsibility extends ResponsibilityI {

    /**
     * 初始化该处理器的责任等级
     */
    public HusbandResponsibility(int responsibilityLevel) {
        super(responsibilityLevel);
    }

    @Override
    protected void response() {
        System.out.println("丈夫批准了！");
    }

}
