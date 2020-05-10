package designpattern.templatemethod;

/**
 * 咖啡因饮料
 */
public abstract class CaffeineBeverage {

    /**
     * 准备秘方-模板方法
     *      使用final不让子类重写
     *      子类实现父类的方法，重新定义算法中的某些步骤
     */
    public final void prepareRecipe() {
        boilWater();

        //使用钩子方法判断添加作料
        if (customerWantCondiment()) {
            addCondiments();
        }
        brew();
        pourInCup();
    }

    public void boilWater() {
        System.out.println("煮开水");
    }

    /**
     * 添加作料的抽象方法
     */
    public abstract void addCondiments();

    /**
     * 泡饮料的抽象方法
     */
    public abstract void brew();

    public void pourInCup() {
        System.out.println("倒入杯子里");
    }

    /**
     * 钩子方法，子类可重写 自定义是否添加作料
     */
    public boolean customerWantCondiment() {
        return true;
    }

}
