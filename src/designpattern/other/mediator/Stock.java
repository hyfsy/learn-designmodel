package designpattern.other.mediator;

/**
 * 库房管理人员类
 */
public class Stock extends AbstractColleague {

    /**
     * 库存数量
     */
    private static int stockNumber = 100;

    public Stock(AbstractMediator mediator) {
        super(mediator);
    }

    /**
     * 增加库存
     */
    public void increase(int stockNumber) {
        this.setStockNumber(this.getStockNumber() + stockNumber);
        System.out.println("库存数量：" + this.getStockNumber());
    }

    /**
     * 减少库存
     */
    public void decrease(int stockNumber) {
        this.setStockNumber(this.getStockNumber() - stockNumber);
        System.out.println("库存数量：" + this.getStockNumber());
    }

    /**
     * 清仓处理
     */
    public void clearStock() {
        System.out.println("清仓的电脑数量：" + this.getStockNumber());
        this.mediator.execute(OrderConstValue.STOCK_CLEAR_COMPUTER);
    }

    /**
     * 获取库存
     */
    public int getStockNumber() {
        return stockNumber;
    }

    public static void setStockNumber(int stockNumber) {
        Stock.stockNumber = stockNumber;
    }
}
