package designpattern.factory.singlecall;

/**
 * 产品
 */
public class Product {

    private String name;

    private boolean canChange = false;

    public Product(ProductManager manager, String name) {
        //如果工厂允许创建，才能创建
        if (manager.isCreateProduct()) {
            this.canChange = true;
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (canChange) {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", canChange=" + canChange +
                '}';
    }
}
