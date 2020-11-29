package designpattern.other.chainofresponsibility.spring;

/**
 * 责任链中实际执行处理的接口
 *
 * @author baB_hyf
 * @date 2020/11/29
 */
public interface Invoker {

    void invoke(InvokerChain chain);

}
