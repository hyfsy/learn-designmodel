package designpattern.state;

/**
 * 售完状态类
 */
public class SoldOutState implements State {

    private transient GumBallMachine gumBallMachine;

    public SoldOutState(GumBallMachine gumBallMachine){
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("糖果已经卖完了");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你还没有投入25分钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("糖果已经卖完了");
    }

    @Override
    public void dispense() {
        System.out.println("糖果已经卖完了");
    }

}
