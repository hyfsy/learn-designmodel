package designpattern.other.mediator;

import java.util.Random;

/**
 * 销售人员类
 */
public class Sale extends AbstractColleague {

    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    /**
     * 销售电脑
     */
    public void sellComputer(int number){
        this.mediator.execute(OrderConstValue.SALE_SELL_COMPUTER,number);
    }

    /**
     * 打折促销电脑
     */
    public void offSellComputer(){
        this.mediator.execute(OrderConstValue.SALE_OFFSELL_COMPUTER);
    }

    /**
     * 获取销售状态（0-100）
     */
    public int getSaleStatus(){
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("销售情况为："+saleStatus);
        return saleStatus;
    }

}
