package designpattern.other.chainofresponsibility;

/**
 * 责任链主要抽象类
 */
public abstract class ResponsibilityI {

    private ResponsibilityI nextResponsibility = null;

    private int responsibilityLevel;

    /**
     * 初始化该处理器的责任等级
     */
    public ResponsibilityI(int responsibilityLevel) {
        this.responsibilityLevel = responsibilityLevel;
    }

    /**
     * 设置下一个责任
     */
    public void setNextResponsibility(ResponsibilityI nextResponsibility) {
        this.nextResponsibility = nextResponsibility;
    }

    /**
     * 责任链固定的处理方式，不能重写
     */
    public final void handleMessage(IWomen women) {
        if (women.getType() == this.responsibilityLevel) {
            //符合等级执行对应操作
            this.response();
        } else {
            if (this.nextResponsibility != null) {
                //给责任链的下一个去处理
                this.nextResponsibility.handleMessage(women);
            } else {
                //都不符合的默认操作
                System.out.println("没地方请示了，按不同意处理");
            }
        }
    }

    /**
     * 不同的责任链 不同的处理方式
     */
    protected abstract void response();
}
