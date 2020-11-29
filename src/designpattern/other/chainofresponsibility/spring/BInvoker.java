package designpattern.other.chainofresponsibility.spring;

/**
 * @author baB_hyf
 * @date 2020/11/29
 */
public class BInvoker implements Invoker {

    @Override
    public void invoke(InvokerChain chain) {
        System.out.println("B start invoke");
        chain.invoke();
        System.out.println("B end invoke");
    }

}
