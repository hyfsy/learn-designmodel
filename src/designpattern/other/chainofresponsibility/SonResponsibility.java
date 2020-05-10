package designpattern.other.chainofresponsibility;

/**
 * 儿子的责任
 */
public class SonResponsibility extends ResponsibilityI {

    /**
     * 初始化该处理器的责任等级
     */
    public SonResponsibility(int responsibilityLevel) {
        super(responsibilityLevel);
    }

    @Override
    protected void response() {
        System.out.println("儿子批准了！");
    }

}
