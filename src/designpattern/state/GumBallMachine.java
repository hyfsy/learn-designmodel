package designpattern.state;

/**
 * 糖果机（状态模式(主类)和远程代理结合）
 *
 * 远程代理修改：
 * 状态接口 由于需要远程传递 必须扩展序列化接口
 * 状态实现类的糖果机对象不需要一起传递 添加transient
 */
public class GumBallMachine {

    private int count;

    private State noQuarterState;
    private State hasQuarterState;
    private State soldOutState;
    private State soldState;
    private State luckState;

    private State state;

    public GumBallMachine(int count) {
        this.count = count;
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldOutState = new SoldOutState(this);
        this.soldState = new SoldState(this);
        this.luckState = new LuckState(this);
        if (count > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    public void dispense() {
        state.dispense();
    }

    /**
     * 糖果机本身的发放糖果方法
     */
    public void releaseBall() {
        System.out.println("一个糖果出来啦！");
        if (count > 0) {
            count--;
        }
    }

    /**
     * 获取糖果机的剩余糖果个数
     */
    public int getCount() {
        return count;
    }

    /**
     * 改变糖果机的状态
     */
    public void changeState(State state) {
        if(state instanceof SoldOutState){
            refill(5);
        }else{
            this.state = state;
        }
    }

    /**
     * 默认重新填装五个糖果
     */
    public void refill(int count){
        System.out.println("\n正在重新填装糖果......\n");
        this.count = count;
        this.state = noQuarterState;
    }

    /**
     * 通过调用糖果机的获取状态方法，让状态之间解耦
     */
    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getLuckState() {
        return luckState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
