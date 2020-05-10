package designpattern.other.mediator;

/**
 * 中介者模式
 *
 * 用一个中介对象封装一系列的对象交互,中介者使各对象不需要显示地相互作用,
 *      从而使其耦合松散,而且可以独立地改变它们之间的交互
 *
 * 为什么同事类要使用构造函数注入中介者,而中介者使用getter/setter方式注入同事类呢?
 * 答：这是因为同事类必须有中介者，而中介者却可以只有部分同事类。
 *
 *
 * 同事本身的行为：自发行为（Self-Method）
 * 依靠中介者的行为：依赖方法（Dep-Method）
 *
 * 优点：减少类间的依赖,把原有的一对多的依赖变成了一对一的依赖
 * 缺点：同事类越多,中介者的逻辑就越复杂
 */
public class Test {
    public static void main(String[] args) {

        //创建中介者对象
        AbstractMediator mediator = new ConcreteMediator();
        //创建同事对象
        Purchase purchase = new Purchase(mediator);
        Sale sale = new Sale(mediator);
        Stock stock = new Stock(mediator);

        //设置同事类
        mediator.setPurchase(purchase);
        mediator.setSale(sale);
        mediator.setStock(stock);

        //通过中介者互相操作
        purchase.buyComputer(1024);
        //此处由于库存不足会自动购买，再售卖
        sale.sellComputer(2000);
        stock.clearStock();

    }
}
