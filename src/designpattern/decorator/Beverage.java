package designpattern.decorator;

/**
 * 咖啡基类
 */
public abstract class Beverage {

    String description = "Normal Coffee";

    /**
     * 获取咖啡描述
     *
     * @return 咖啡描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 计算咖啡价格
     *
     * @return 咖啡价格
     */
    public abstract double cost();
}
