package designpattern.other.mediator;

/**
 * 抽象同事类，同事类几乎没有什么共有的方法
 */
public abstract class AbstractColleague {

    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
