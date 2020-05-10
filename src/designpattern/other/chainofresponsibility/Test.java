package designpattern.other.chainofresponsibility;

/**
 * 责任链模式
 *
 * 使多个对象都有机会处理请求,从而避免了请求的发送者和接受者之间的耦合关系。
 *      将这些对象连成一条链,并沿着这条链传递该请求，直到有对象处理它为止
 *
 * 优点：将请求和处理完全解耦
 * 缺点：性能问题
 */
public class Test {
    public static void main(String[] args) {

        //创建对象，由不同的处理器处理不同状态的对象
        IWomen women = new ConcreteWomen(WomenTypeConstValue.HAS_HUSBAND);

        //创建一个个责任链
        ResponsibilityI fatherResponsibility = new FatherResponsibility(WomenTypeConstValue.HAS_NO_HUSBAND);
        ResponsibilityI husbandResponsibility = new HusbandResponsibility(WomenTypeConstValue.HAS_HUSBAND);
        ResponsibilityI sonResponsibility = new SonResponsibility(WomenTypeConstValue.DEAD_HUSBAND);

        //设置链条的顺序
        fatherResponsibility.setNextResponsibility(husbandResponsibility);
        husbandResponsibility.setNextResponsibility(sonResponsibility);

        //由链条的第一个 处理信息
        fatherResponsibility.handleMessage(women);
    }
}
