package designpattern.other.mediator;

/**
 * 采购人员类
 */
public class Purchase extends AbstractColleague {

    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    public void buyComputer(int number) {
        super.mediator.execute(OrderConstValue.PURCHASE_BUY_COMPUTER, number);
    }

    public void refuseComputer() {
        System.out.println("不再购买电脑了");
    }

}
