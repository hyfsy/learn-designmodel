package designpattern.state;

/**
 * 没有硬币投入状态
 */
public class NoQuarterState implements State {

    private transient GumBallMachine gumBallMachine;

    public NoQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("放入了25分钱");
        gumBallMachine.changeState(gumBallMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你还没有投入25分钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("你转动了曲柄，但是你没有投入25分钱");
    }

    @Override
    public void dispense() {
        System.out.println("你需要先付25分钱");
    }
}
