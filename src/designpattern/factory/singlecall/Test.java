package designpattern.factory.singlecall;

/**
 * 单来源调用
 * 一个对象只能由固定的对象初始化的方法就叫做单来源调用(Single Call)
 *
 * 注意
 * 采用单来源调用的两个对象一般是组合关系,两者有相同的生命期,
 * 它通常适用于有单例模式和工厂方法模式的场景中
 */
public class Test {
    public static void main(String[] args) {
        Product product = new Product(new ProductManager(), "测试名称");
        System.out.println("创建失败：" + product);

        Product product1 = new ProductManager().createProduct("测试名称");
        System.out.println("创建成功：" + product1);
    }
}
