package designpattern.state;

/**
 * 十分之一抽中两个糖果的幸运状态类
 */
public class LuckState implements State {

    private transient GumBallMachine gumBallMachine;

    public LuckState(GumBallMachine gumBallMachine) {
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
        //出第一个糖果
        gumBallMachine.releaseBall();
        //判断糖果个数改变对应状态
        if (gumBallMachine.getCount() > 0) {
            //出第二个糖果
            gumBallMachine.releaseBall();
            if (gumBallMachine.getCount() > 0) {
                gumBallMachine.changeState(gumBallMachine.getNoQuarterState());
                return;
            }
        }
        gumBallMachine.changeState(gumBallMachine.getSoldOutState());
    }
}
