package designpattern.other.mediator;

/**
 * 抽象中介者
 */
public abstract class AbstractMediator {

    /**
     * 三名同事
     */
    protected Purchase purchase = null;
    protected Sale sale = null;
    protected Stock stock = null;

    public abstract void execute(String order, Object... objects);


    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
