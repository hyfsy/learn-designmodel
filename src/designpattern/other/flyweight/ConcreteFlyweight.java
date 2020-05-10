package designpattern.other.flyweight;

/**
 * 享元角色的实现类
 */
public class ConcreteFlyweight implements Flyweight {

    //内部（固有）状态
    private String intrinsicState = null;

    /**
     * 构造初始化内部状态
     */
    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    /**
     * 注意！ 在程序开发中,确认只需要一次赋值的属性则设置为final类型
     * 避免无意修改导致逻辑特别是Session级的常量或变量。
     *
     * @param state 此处的外部状态变成常量设置final类型
     */
    @Override
    public void operation(String state) {
        System.out.println("intrinsic state: " + this.intrinsicState);
        System.out.println("extrinsic state: " + state);
        System.out.println("hashcode: " + this.hashCode());
    }

}
