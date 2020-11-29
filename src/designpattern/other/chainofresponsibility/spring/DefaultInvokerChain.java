package designpattern.other.chainofresponsibility.spring;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 责任链制作器，用于制作一条Invoker的责任链
 *
 * @author baB_hyf
 * @date 2020/11/29
 */
public class DefaultInvokerChain implements InvokerChain {

    private final InvokerChain nextChain;
    private final Invoker      invoker;

    public DefaultInvokerChain(List<Invoker> chains) {
        chains = chains != null ? chains : Collections.emptyList();

        DefaultInvokerChain chain = initChain(chains);
        this.nextChain = chain.nextChain;
        this.invoker = chain.invoker;
    }

    private DefaultInvokerChain(Invoker invoker, InvokerChain nextChain) {
        this.nextChain = nextChain;
        this.invoker = invoker;
    }

    private DefaultInvokerChain initChain(List<Invoker> chains) {
        ListIterator<Invoker> iterator = chains.listIterator(chains.size());

        DefaultInvokerChain chain = new DefaultInvokerChain(null, null);
        while (iterator.hasPrevious()) {
            chain = new DefaultInvokerChain(iterator.previous(), chain);
        }
        return chain;
    }

    @Override
    public void invoke() {
        if (this.nextChain != null && this.invoker != null) {
            this.invoker.invoke(this.nextChain);
        }
    }

}
