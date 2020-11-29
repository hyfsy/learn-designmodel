package designpattern.other.chainofresponsibility.spring;

/**
 * @author baB_hyf
 * @date 2020/11/29
 */
public class CInvoker implements Invoker {

    @Override
    public void invoke(InvokerChain chain) {
        System.out.println("C start invoke");
        chain.invoke();
        System.out.println("C end invoke");
    }

}
