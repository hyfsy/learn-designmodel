package designpattern.other.chainofresponsibility.spring;

/**
 * @author baB_hyf
 * @date 2020/11/29
 */
public class AInvoker implements Invoker {

    @Override
    public void invoke(InvokerChain chain) {
        System.out.println("A start invoke");
        chain.invoke();
        System.out.println("A end invoke");
    }

}
