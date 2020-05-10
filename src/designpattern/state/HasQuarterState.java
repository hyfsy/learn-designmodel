package designpattern.state;

import java.util.Random;

/**
 * 已放入25分钱状态
 */
public class HasQuarterState implements State {

    private transient GumBallMachine gumBallMachine;

    /**
     * 生成一个随机器
     */
    private Random random = new Random(System.currentTimeMillis());
    private int luckNum = 0;

    public HasQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你已经投入了25分钱，不能再投入了");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("吐出了25分钱");
        gumBallMachine.changeState(gumBallMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("转动了转轴");
        int winner = random.nextInt(10);
        //判断是否中奖,要求糖果个数至少为两个
        if (winner == luckNum && gumBallMachine.getCount() > 1) {
            System.out.println("恭喜你，中大奖了！！！");
            gumBallMachine.changeState(gumBallMachine.getLuckState());
        } else {
            gumBallMachine.changeState(gumBallMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("没有糖果可以发放");
    }
}
