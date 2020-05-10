package designpattern.factory.singlecall;

/**
 * 产品工厂
 */
public class ProductManager {

    //被允许创建
    private boolean isPermittedCreate = false;

    /**
     * 创建产品
     */
    public Product createProduct(String name) {
        //修改权限，允许创建
        this.isPermittedCreate = true;
        return new Product(this, name);
    }

    public boolean isCreateProduct() {
        return isPermittedCreate;
    }

}
