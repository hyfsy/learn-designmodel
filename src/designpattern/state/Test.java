package designpattern.state;

public class Test {
    public static void main(String[] args) {
        GumBallMachine gumBallMachine = new GumBallMachine(5);
        for(int i=0;i<6;i++) {
            gumBallMachine.insertQuarter();
            gumBallMachine.insertQuarter();
            gumBallMachine.ejectQuarter();
            gumBallMachine.insertQuarter();
            gumBallMachine.turnCrank();
            gumBallMachine.dispense();
            System.out.println();
        }
    }
}
