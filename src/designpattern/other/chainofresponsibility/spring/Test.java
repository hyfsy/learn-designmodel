package designpattern.other.chainofresponsibility.spring;

import java.util.Arrays;

/**
 * 参考Spring学习的新的责任链制作器
 *
 * @author baB_hyf
 * @date 2020/11/29
 * @see DefaultResourceResolverChain
 * @see ResourceTransformerChain
 */
public class Test {

    public static void main(String[] args) {

        Invoker a = new AInvoker();
        Invoker b = new BInvoker();
        Invoker c = new CInvoker();

        DefaultInvokerChain chain = new DefaultInvokerChain(Arrays.asList(a, b, c));
        chain.invoke();


    }
}
