package designpattern.other.mediator;

/**
 * 具体中介者
 */
public class ConcreteMediator extends AbstractMediator {

    /**
     * 重要的执行方法
     *
     * @param order   命令方法
     * @param objects 方法参数
     */
    @Override
    public void execute(String order, Object... objects) {
        switch (order) {
            case OrderConstValue.PURCHASE_BUY_COMPUTER:
                this.buyComputer((Integer) objects[0]);
                break;
            case OrderConstValue.SALE_SELL_COMPUTER:
                this.sellComputer((Integer) objects[0]);
                break;
            case OrderConstValue.SALE_OFFSELL_COMPUTER:
                this.offSellComputer();
                break;
            case OrderConstValue.STOCK_CLEAR_COMPUTER:
                this.clearComputer();
                break;
            default:
                System.out.println("错误的方法命令");
                break;
        }
    }

    //==============================同事类之间的相互操作================================

    public void buyComputer(int number) {
        //判断销售情况是否良好
        int saleStatus = this.sale.getSaleStatus();
        int buyNumber = 0;
        if (saleStatus > 80) {
            buyNumber = number;
        } else {
            buyNumber = number / 2;
        }
        System.out.println("采购了电脑 " + buyNumber + " 台");
        this.stock.increase(buyNumber);
    }

    public void sellComputer(int number) {
        if (stock.getStockNumber() < number) {
            purchase.buyComputer(number);
        }
        this.stock.decrease(number);
    }

    public void offSellComputer() {
        System.out.println("打折销售电脑 " + stock.getStockNumber() + " 台");
    }

    public void clearComputer() {
        this.sale.offSellComputer();
        this.purchase.refuseComputer();
    }

}
