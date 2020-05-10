package designpattern.state;

/**
 * 发放糖果状态类
 */
public class SoldState implements State {

    private transient GumBallMachine gumBallMachine;

    public SoldState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("请稍后，正在出糖果...");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("抱歉，你已经转过曲柄，不能把钱退给你了");
    }

    @Override
    public void turnCrank() {
        System.out.println("不会因为转两次就拿到两个糖果");
    }

    @Override
    public void dispense() {
        gumBallMachine.releaseBall();
        //判断糖果个数改变对应状态
        if (gumBallMachine.getCount() > 0) {
            gumBallMachine.changeState(gumBallMachine.getNoQuarterState());
        } else {
            gumBallMachine.changeState(gumBallMachine.getSoldOutState());
        }
    }
}
